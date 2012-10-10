/*
 * Copyright (C) 2012 Jose Enrique Pons Frías <jpons@decsai.ugr.es>.
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

package es.jpons.persistence.exception;

/**
 * Wrapper class to exception. It is usually thrown in case of insert error.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 10/10/2012
 * 
 */
public class TemporalInsertException extends Exception{

    public TemporalInsertException() {
    }

    public TemporalInsertException(String string) {
        super(string);
    }

    public TemporalInsertException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public TemporalInsertException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    

}
