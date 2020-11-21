/**
 * @author: Brian Yen, bfy2101
 * Record class is a data structure to hold format and values for each record being
 * streamed.
 *
 */

public class Record {
    private String[] recordFieldNames;
    private String[] recordFieldTypes;
    private String[] recordFieldValues;

    public Record(String[] recordColumns){
        this.recordFieldValues = recordColumns;
    }

    /**
     * describes format record must adhere to.
     * @param headerFormat: format of header.
     * @param fieldFormat: format of field types.
     */
    public void setRecordFormat(String[] headerFormat, String[] fieldFormat){
        this.recordFieldNames = headerFormat;
        this.recordFieldTypes = fieldFormat;
    }

    /**
     *
     * @param selectFieldName: field name to select on
     * @param selectFieldValue: field value to select on
     * @return to say if output has good format and matches select operation criteria.
     */
    public boolean matchesFormat(String selectFieldName, String selectFieldValue){
        boolean matchesFormat = false;
        for(int i = 0; i < recordFieldValues.length; i++){
            String columnName = getFieldNameAtIndex(i);
            String columnType = getFieldTypesAtIndex(i);
            String columnValue = getFieldValuesAtIndex(i);

            if(checkFieldFormat(columnType, columnValue)){
                if(columnName.equals(selectFieldName) && columnValue.equals(selectFieldValue)){
                    matchesFormat = true;
                }
                if(selectFieldName.equals("None") && selectFieldValue.equals("None")){
                    matchesFormat = true;
                }
            }
            else{
                matchesFormat = false;
                break;
            }
        }
        return matchesFormat;
    }

    public int getNumberOfFields(){
        return recordFieldNames.length;
    }

    public String getFieldNameAtIndex(int index){
        return recordFieldNames[index];
    }

    public String getFieldTypesAtIndex(int index){
        return recordFieldTypes[index];
    }

    public String getFieldValuesAtIndex(int index){
        return recordFieldValues[index];
    }

    private boolean checkFieldFormat(String columnType, String columnValue){
        boolean matchesFormat;

        if(columnType.equals("byte")){
            try{
                int temp = Byte.parseByte(columnValue);
                matchesFormat = true;
            } catch(Exception e){
                matchesFormat = false;
            }
        }
        else if(columnType.equals("long")){
            try{
                long temp = Long.parseLong(columnValue);
                matchesFormat = true;
            } catch(Exception e){
                matchesFormat = false;
            }
        }
        else if(columnType.equals("int")){
            try{
                int temp = Integer.parseInt(columnValue);
                matchesFormat = true;
            } catch(Exception e){
                matchesFormat = false;
            }
        }
        else if(columnType.equals("short")){
            try{
                short temp = Short.parseShort(columnValue);
                matchesFormat = true;
            } catch (Exception e) {
                matchesFormat = false;
            }
        }
        else if(columnType.equals("float")){
            try{
                float temp = Float.parseFloat(columnValue);
                matchesFormat = true;
            } catch (Exception e) {
                matchesFormat = false;
            }
        }
        else if(columnType.equals("double")){
            try{
                double temp = Double.parseDouble(columnValue);
                matchesFormat = true;
            } catch (Exception e) {
                matchesFormat = false;
            }
        }
        else if(columnType.equals("String")){
            matchesFormat = true;
        }
        else{
            matchesFormat = false;
        }

        return matchesFormat;
    }

}
