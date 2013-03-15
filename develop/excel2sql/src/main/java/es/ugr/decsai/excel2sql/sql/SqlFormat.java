/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to write sql code
 *
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
    private static final String INSERT = "INSERT";
    private static final String INTO = "INTO";
    private static final String VALUES = "VALUES";
    private static final String PARAM = "?";
    private static final String EMPTY_STRING = "";
    protected AbstractSQLRenderer sqlTypeRender;

    public SqlFormat(AbstractSQLRenderer sqlTypeRender) {
        this.sqlTypeRender = sqlTypeRender;
    }

    public String createSentece(String tableName, List<String> fieldName, List<SqlDatatypes> fieldType) {
        String commandText = TOKEN_CREATE + BLANK + TOKEN_TABLE + BLANK + tableName + BLANK + LEFT_PARENTHESIS;

        for (int i = 0; i < fieldName.size(); i++) {
            commandText += SIMPLE_COMMA + fieldName.get(i) + SIMPLE_COMMA + BLANK + sqlTypeRender.render(fieldType.get(i));
            if (i < fieldName.size() - 1) {
                commandText += COMMA;
            }
        }


        commandText += BLANK + RIGHT_PARENTHESIS + END;
        return commandText;
    }

    public String insertSentence(String tableName, List<String> values, List<SqlDatatypes> fieldType) {
        String commandText = INSERT + BLANK + INTO + BLANK + tableName + BLANK + VALUES + LEFT_PARENTHESIS;
        for (int i = 0; i < values.size(); i++) {
            commandText += sqlTypeRender.renderValue(fieldType.get(i), values.get(i));
            if (i < values.size() - 1) {
                commandText += COMMA;
            }
        }
        commandText += BLANK + RIGHT_PARENTHESIS + END;
        return commandText;
    }

    public void insertDatabase(String tableName, List<String> values, List<SqlDatatypes> fieldType, List<String> attributes, Connection conn) {
        String commandText = INSERT + BLANK + INTO + BLANK + tableName + BLANK + LEFT_PARENTHESIS;
        String valuesParam = LEFT_PARENTHESIS;


        for (int i = 0; i < values.size(); i++) {
            commandText += sqlTypeRender.renderValue(SqlDatatypes.STRING, attributes.get(i));
            valuesParam += PARAM;
            if (i < values.size() - 1) {
                commandText += COMMA;
                valuesParam += COMMA;
            }
        }
        commandText += RIGHT_PARENTHESIS + BLANK + VALUES + BLANK;
        valuesParam += RIGHT_PARENTHESIS;

        commandText += valuesParam;

//        System.out.println(commandText);
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(commandText);
            for (int i = 0; i < values.size(); i++) {
               // System.out.println("Field: " + i + " value: " + values.get(i));
                int index = i + 1;
                if (isNull(values.get(i))) {
                    stm.setNull(index, Types.NULL);
                   // System.out.println("is null");
                } else {

                    switch (fieldType.get(i)) {
                        case DOUBLE:
                           
                            try{
                               
                                stm.setDouble(index, new Double(values.get(i)));
                            }catch(NumberFormatException ex){
                                stm.setNull(index, Types.NULL);
                            }
                            
                            
                            break;
                        case INTEGER:
                            try{
                            stm.setInt(index, new Integer(values.get(i)));
                            }catch(NumberFormatException ex){
                                stm.setNull(index, Types.NULL);
                            }
                            break;
                        case STRING:
                            stm.setString(index, values.get(i));
                            break;
                        default:
                            stm.setString(index, values.get(i));
                    }
                }
            }
            stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SqlFormat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }




    }

    protected List<String> inflate(List<String> values, List<String> attributes) {
        List<String> valueList = values;
        if (values.size() < attributes.size()) {
            int oldSize = values.size();
            int newSize = attributes.size();

            for (int i = 0; i < (newSize - oldSize); i++) {
                valueList.add(BLANK);
            }
        }
        return valueList;
    }

    protected boolean isNull(String value) {
        return value.trim().compareTo(EMPTY_STRING) == 0;
    }
    
}
