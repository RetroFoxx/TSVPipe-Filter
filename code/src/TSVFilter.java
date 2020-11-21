/**
 * @author: Brian Yen, bfy2101
 * TSVFilter is a class to represent the Builder pattern filter..
 *
 */

public class TSVFilter {
    private TSVFilter(WhichFile inFile){
        required = inFile.required;
        selectOptionName = inFile.selectOptionName;
        selectOptionValue = inFile.selectOptionValue;
        fieldToTerminateOn = inFile.fieldToTerminateOn;
        userTerminalObservation = inFile.userTerminalObservation;
    }

    /**
     * @return filename which is required information.
     */
    public String getRequired(){
        return required;
    }

    /**
     * @return get option for select operation
     */
    public String getSelectOptionName(){
        return selectOptionName;
    }

    /**
     * @return get the value specified for select operation
     */
    public String getSelectOptionValue() {
        return selectOptionValue;
    }

    /**
     * @return get field that user specify to terminate on
     */
    public String getFieldToTerminateOn(){
        return fieldToTerminateOn;
    }

    /**
     * @return terminal observation operation (MAX or MIN).
     */
    public TerminalObservation getUserTerminalObservation(){
        return userTerminalObservation;
    }

    /**
     * @override
     * @return string output for created TSVFilter
     */
    public String toString(){
        return "TSVFilter "
                + "{ required = "     + required     +   "\n"
                + ", selectOptionName = "  + selectOptionName
                + ", selectOptionValue = " + selectOptionValue
                + ", fieldToTerminateOn = " + fieldToTerminateOn
                + ", terminalObservation = " + userTerminalObservation + "}";
    }

    public static class WhichFile{
        /**
         * explicitly set default to null select and null terminate object
         * @param fileName: required
         */
        public WhichFile(String fileName){
            required = fileName;
            selectOptionName = "None";
            selectOptionValue = "None";
            fieldToTerminateOn = "None";
            userTerminalObservation = TerminalObservation.NONE;
        }

        /**
         *
         * @param fieldName: field specified for select operation
         * @param fieldValue: value specified for select operation
         * @return WhichFile object
         */
        public WhichFile select(String fieldName, String fieldValue){
            selectOptionName = fieldName;
            selectOptionValue = fieldValue;
            return this;
        }

        /**
         * @override: override for number fieldValue
         * @return WhichFile object
         */
        public WhichFile select(String fieldName, int fieldValue){
            selectOptionName = fieldName;
            selectOptionValue = String.valueOf(fieldValue);
            return this;
        }

        /**
         *
         * @param fieldName: field to terminate on
         * @param inputTerminalObservation: terminalObservation operation
         * @return WhichFile object
         */
        public WhichFile terminate(String fieldName,
                                   TerminalObservation
                                           inputTerminalObservation){
            fieldToTerminateOn = fieldName;
            userTerminalObservation = inputTerminalObservation;
            return this;
        }

        /**
         *  Builder method to return the full object,
         *  makes inner object into outer object
         * @return full object
         */
        public TSVFilter done(){
            return new TSVFilter(this);
        }

        private final String required;
        private String selectOptionName;
        private String selectOptionValue;
        private String fieldToTerminateOn;
        private TerminalObservation userTerminalObservation;

    }

    private final String required;
    private final String selectOptionName;
    private final String selectOptionValue;
    private final String fieldToTerminateOn;
    private final TerminalObservation userTerminalObservation;
}
