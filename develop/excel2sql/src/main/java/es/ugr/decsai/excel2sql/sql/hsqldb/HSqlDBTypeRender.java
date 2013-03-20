/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql.sql.hsqldb;

import es.ugr.decsai.excel2sql.sql.AbstractSQLRenderer;
import es.ugr.decsai.excel2sql.sql.SqlDatatypes;
import static es.ugr.decsai.excel2sql.sql.SqlDatatypes.DOUBLE;
import static es.ugr.decsai.excel2sql.sql.SqlDatatypes.INTEGER;
import static es.ugr.decsai.excel2sql.sql.SqlDatatypes.STRING;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class HSqlDBTypeRender extends AbstractSQLRenderer{

    @Override
    public String render(SqlDatatypes type) {
         String render;
        switch(type){
            case DOUBLE: render = HSqlDBDatatypes.DOUBLE.name();
                break;
            case INTEGER: render = HSqlDBDatatypes.INTEGER.name();
                break;
            case STRING: render = HSqlDBDatatypes.LONGVARCHAR.name();
                break;
            default:
                render = HSqlDBDatatypes.LONGVARCHAR.name();
        }
        
        
        return render;
    }
    
}
