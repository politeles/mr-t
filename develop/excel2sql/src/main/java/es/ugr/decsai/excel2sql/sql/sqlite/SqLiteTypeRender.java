/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql.sql.sqlite;

import es.ugr.decsai.excel2sql.sql.AbstractSQLRenderer;
import es.ugr.decsai.excel2sql.sql.SqlDatatypes;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 */
public class SqLiteTypeRender extends AbstractSQLRenderer{

    /**
     * Implementation of the interface TypeRender.
     * Returns the datatypes in SqLite.
     * @param type
     * @return 
     */
    public String render(SqlDatatypes type){
        String render="";
        switch(type){
            case DOUBLE: render = SqLiteDatatypes.REAL.name();
                break;
            case INTEGER: render = SqLiteDatatypes.INTEGER.name();
                break;
            case STRING: render = SqLiteDatatypes.TEXT.name();
                break;
            default:
                render = SqLiteDatatypes.TEXT.name();
        }
        
        
        return render;
    }
}
