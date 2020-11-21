import java.lang.Math;

/**
 * @author: Brian Yen, bfy2101
 * Statistics class is for running calculations for terminal operations. For each passing record,
 * store min or max value of records that have been streamed.
 *
 */

public class Statistics {
    TerminalObservation userTerminalObservation;
    private double numberMaxValue = 0;
    private double numberMinValue = 0;
    private String stringMaxValue = "";
    private String stringMinValue = "";

    /**
     *
     * @param inputTerminalObservation: enum that specifies either null object by NONE
     *                                or MIN/MAX observation.
     */
    public Statistics(TerminalObservation inputTerminalObservation){
        this.userTerminalObservation = inputTerminalObservation;
    }

    /**
     * gathers information based on observation specified and observes
     * each record
     * @param fieldName: field terminate on
     * @param record: record that has good format that has passed select operation
     */
    public void gatherInfo(String fieldName, Record record){
        switch(userTerminalObservation){
            case MAX:
                compareMax(fieldName, record);
                break;
            case MIN:
                compareMin(fieldName, record);
                break;
            default:
                break;
        }
    }

    /**
     * print to system console the output of desired operation, default does nothing.
     */
    public void reportObservations(){
        switch (userTerminalObservation){
            case MAX:
                displayMax();
                break;
            case MIN:
                displayMin();
                break;
            default:
                break;
        }
    }

    private void compareMax(String fieldName, Record record){
        for(int i = 0; i < record.getNumberOfFields(); i++){
            String columnName = record.getFieldNameAtIndex(i);
            String columnType = record.getFieldTypesAtIndex(i);
            String columnValue = record.getFieldValuesAtIndex(i);

            if(columnName.equals(fieldName)){
                if(columnType.equals("String")){
                    compareMaxString(columnValue);
                }
                else{
                    compareMaxNumber(columnValue);
                }
            }
        }
    }

    private void compareMin(String fieldName, Record record){
        for(int i = 0; i < record.getNumberOfFields(); i++){
            String columnName = record.getFieldNameAtIndex(i);
            String columnType = record.getFieldTypesAtIndex(i);
            String columnValue = record.getFieldValuesAtIndex(i);

            if(columnName.equals(fieldName)){
                if(columnType.equals("String")){
                    compareMinString(columnValue);
                }
                else{
                    compareMinNumber(columnValue);
                }
            }
        }
    }

    private void compareMaxNumber(String fieldValue){
        try{
            double value = Double.parseDouble(fieldValue);
            if(numberMaxValue == 0){
                numberMaxValue = value;
            }
            numberMaxValue = Math.max(numberMaxValue, value);
        } catch (Exception e){
            System.out.println("Cannot find max for type");
        }
    }

    private void compareMinNumber(String fieldValue){
        try{
            double value = Double.parseDouble(fieldValue);
            if(numberMinValue == 0){
                numberMinValue = value;
            }
            numberMinValue = Math.min(numberMinValue, value);
        } catch (Exception e){
            System.out.println("Cannot find max for type");
        }
    }

    private void compareMaxString(String fieldValue){
        if(stringMaxValue.equals("")) {
            stringMaxValue = fieldValue;
        }
        else {
            int stringCompare = stringMaxValue.compareTo(fieldValue);
            if (stringCompare > 0) {
                stringMaxValue = fieldValue;
            }
        }
    }

    private void compareMinString(String fieldValue){
        if(stringMinValue.equals("")){
            stringMinValue = fieldValue;
        }
        else{
            int stringCompare = stringMinValue.compareTo(fieldValue);
            if(stringCompare < 0){
                stringMinValue = fieldValue;
            }
        }
    }

    private void displayMax(){
        String maxString;
        if(stringMaxValue.equals("")){
            maxString = String.valueOf(numberMaxValue);
        }
        else{
            maxString = stringMaxValue;
        }
        System.out.println("Max value is " + maxString);
    }

    private void displayMin(){
        String minString;
        if(stringMinValue.equals("")){
            minString = String.valueOf(numberMinValue);
        }
        else{
            minString = stringMinValue;
        }
        System.out.println("Min value is " + minString);
    }

}
