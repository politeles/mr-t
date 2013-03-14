/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql;

import java.util.List;

/**
 * Class to write sql code
 * @author Jose
 */
public class SqlFormat {
    private static final String BLANK = " ";
    private static final String LEFT_PARENTHESIS = " ( ";
    private static final String RIGHT_PARENTHESIS = " ) ";
    private static final String TOKEN_CREATE = "CREATE";
    private static final String TOKEN_TABLE = "TABLE";
    private static final String COMMA = " , ";
    private static final String SIMPLE_COMMA = "'";
    private static final String END = ";";
    
    public String createSentece(String tableName, List<String> fieldName, List<String> fieldType){
        String commandText = TOKEN_CREATE + BLANK + TOKEN_TABLE + BLANK + tableName+ BLANK + LEFT_PARENTHESIS;
        
        for(int i=0;i< fieldName.size();i++){
            commandText += SIMPLE_COMMA + fieldName.get(i)+SIMPLE_COMMA+BLANK+fieldType.get(i);
            if(i<fieldName.size()-1){
                commandText += COMMA;
            }
        }
        
        
        commandText += BLANK + RIGHT_PARENTHESIS + END;
        return commandText;
    }
    
}
