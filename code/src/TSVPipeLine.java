import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Brian Yen, bfy2101
 * TSVPipeline class is for representing the pipeline which executes operations based on
 * TSVFilter. if a file exists and has acceptable formatting, then a record object
 * is created and is processed based on TSVFilter.
 *
 */

public class TSVPipeLine {
    TSVFilter userTSVFilter;

    public TSVPipeLine(TSVFilter inTSVFilter){
        userTSVFilter = inTSVFilter;
    }

    /**
     * takes input file, filters and pipes to file and system
     */
    public void doIt(){
        try {
            String fileName = userTSVFilter.getRequired();
            File fileToRead = new File(fileName);
            Scanner input = new Scanner(fileToRead);

            String headerLine = input.nextLine();
            String[] fieldNames = getSplitFields(headerLine);
            String typeLine = input.nextLine();
            String[] fieldTypes = getSplitFields(typeLine);

            if(fileHasGoodColumnFormat(fieldNames, fieldTypes)){
                File outputFile = createOutputFile();
                FileWriter fileWriter = new FileWriter(outputFile);
                String outFile = outputFile.getName();

                printSuccessfulFile(fileName, outFile);
                fileWriter.write(headerLine + "\n");
                fileWriter.write(typeLine + "\n");

                String fieldToSelectOn = userTSVFilter.getSelectOptionName();
                String selectFieldValue = userTSVFilter.getSelectOptionValue();

                String fieldToTerminateOn = userTSVFilter.getFieldToTerminateOn();
                TerminalObservation userTerminateOption;
                userTerminateOption = userTSVFilter.getUserTerminalObservation();
                Statistics processTerminate = new Statistics(userTerminateOption);

                while(input.hasNextLine()){
                    String recordLine = input.nextLine();
                    String[] recordColumns = getSplitFields(recordLine);
                    Record recordToProcess = new Record(recordColumns);
                    recordToProcess.setRecordFormat(fieldNames, fieldTypes);
                    if(recordToProcess.matchesFormat(fieldToSelectOn, selectFieldValue)){
                        processTerminate.gatherInfo(fieldToTerminateOn, recordToProcess);
                        fileWriter.write(recordLine);
                        fileWriter.write("\n");
                    }
                }
                processTerminate.reportObservations();
                fileWriter.close();
            }
            else{
                System.out.println("Bad header or type format" + "\n");
            }
        } catch (IOException e) {
            System.out.println("File does not exist." + "\n");
        }
    }

    /**
     *
     * @return outfile for different outputs, generate new outfile if previous exist
     * @throws IOException
     */
    private File createOutputFile() throws IOException {
        File outputFile = new File("outfile.tsv");
        for(int i = 1; outputFile.exists(); i++){
            outputFile = new File(String.format("outfile%d.tsv", i));
        }
        return outputFile;
    }

    /**
     * greedy (\\s+) to account for multiple spaces.
     * trim() to get rid of any leading whitespace.
     * I used \\s+ rather than \\t+
     * to account for user tab preferences that may be different among users.
     * For example, I changed my tab preferences because I usually use vim to code, so
     * based on my text editor settings,
     * a tab in a file will register as 4 spaces rather than 1 tab character.
     * @param lineOfRecord: string to be split
     * @return array that holds each field.
     */
    private String[] getSplitFields(String lineOfRecord){
        String[] columns = lineOfRecord.trim().split("\\s+");
        return columns;
    }

    private boolean fileHasGoodColumnFormat(String[] fields, String[] types){
        boolean goodFormat = false;
        if(fields.length == types.length){
            goodFormat = checkValidType(types);
        }
        return goodFormat;
    }

    private boolean checkValidType(String[] types){
        boolean containsValidTypes = false;
        for(String type: types){
            containsValidTypes = hasValidType(type);
        }
        return containsValidTypes;
    }

    private boolean hasValidType(String type){
        String[] validTypes = {"String", "byte", "short", "long",
                                "float", "double", "int"};
        boolean contains = Arrays.asList(validTypes).contains(type);
        return contains;
    }

    private void printSuccessfulFile(String inFile, String outFile){
        System.out.println("File " + inFile + " is found and has good format!");
        System.out.println("Output file: " + outFile + "\n");
    }


}
