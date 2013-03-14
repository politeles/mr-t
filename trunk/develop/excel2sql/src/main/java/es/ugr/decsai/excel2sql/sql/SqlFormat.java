/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql.sql;

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
    private static final String INSERT = "INSERT INTO";
    private static final String VALUES = "VALUES";
    
    protected AbstractSQLRenderer sqlTypeRender;

    public SqlFormat(AbstractSQLRenderer sqlTypeRender) {
        this.sqlTypeRender = sqlTypeRender;
    }
    
    
    
    
    public String createSentece(String tableName, List<String> fieldName, List<SqlDatatypes> fieldType){
        String commandText = TOKEN_CREATE + BLANK + TOKEN_TABLE + BLANK + tableName+ BLANK + LEFT_PARENTHESIS;
        
        for(int i=0;i< fieldName.size();i++){
            commandText += SIMPLE_COMMA + fieldName.get(i)+SIMPLE_COMMA+BLANK+ sqlTypeRender.render(fieldType.get(i));
            if(i<fieldName.size()-1){
                commandText += COMMA;
            }
        }
        
        
        commandText += BLANK + RIGHT_PARENTHESIS + END;
        return commandText;
    }
    
    public String insertSentence(String tableName,List<String> values,List<SqlDatatypes> fieldType){
        String commandText = INSERT + BLANK + tableName + BLANK + VALUES + LEFT_PARENTHESIS;
        for(int i =0;i< values.size();i++){
            commandText += sqlTypeRender.renderValue(fieldType.get(i), values.get(i));
            if(i<values.size()-1){
                commandText += COMMA;
            }
        }
        commandText += BLANK + RIGHT_PARENTHESIS + END;
        return commandText;
    }
    
}
