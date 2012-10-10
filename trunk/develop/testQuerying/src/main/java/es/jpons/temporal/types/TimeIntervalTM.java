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

package es.jpons.temporal.types;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 * The representation of a time interval in the triangular model
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 02/10/2012
 * 
 */
@Embeddable
public class TimeIntervalTM implements Serializable{

    protected Date ix;
    protected Date iy;
    
    
   
/**
 * Default constructor.
 */
    public TimeIntervalTM() {
    }
/**
 * Contructor for the triangular model.
 * @param ix The coodinate in the x axis.
 * @param iy  The coordinate in the y axis.
 */
    public TimeIntervalTM(Date ix, Date iy) {
        this.ix = ix;
        this.iy = iy;
    }
    
    
    public void convertFromInterval(Date start,Date end){
        if(start!=null && end != null){
            this.ix = new Date((start.getTime() + end.getTime()) /2);
            this.iy = new Date((end.getTime()-start.getTime())/2);
        }
    }
    
    
    
    
    
}
