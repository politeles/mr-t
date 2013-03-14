/*
 * Copyright (C) 2013 Jose Enrique Pons Frías <jpons@decsai.ugr.es>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package es.ugr.decsai.excel2sql.sql;

/**
 * Abstract class for rendering sql code
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 14/03/2013
 *
 */
public abstract class AbstractSQLRenderer {

    /**
     * Function that returns the rendered type for that SQL type.
     *
     * @param type
     * @return an string with the given datatype.
     */
    public abstract String render(SqlDatatypes type);
}
