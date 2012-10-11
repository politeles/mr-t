/*
 * Copyright (C) 2012 University of Granada, Department of Computer Science and Artificial Intelligence.
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

package es.ugr.decsai.jpons.testapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 02/10/2012
 * 
 */
public class Converter {
    public static void convert(DateTime dt,DateTime de){
         Long ts,te;
        ts = dt.getMillis();
        te = de.getMillis();
        
        Long ix,iy;
        
        ix = (ts+te)/2;
        iy = (te-ts)/2;
        
            System.out.println("ix= "+ix+ " yi = "+iy);
    }

    
    public static void main(String[] args) {
        try {
        DateTime dt,de,ds1,de1,ds2,de2;
        dt = new DateTime().withDayOfMonth(15).withMonthOfYear(3).withYear(2012);
        de = new DateTime().withDayOfMonth(30).withMonthOfYear(3).withYear(2012);
        
        ds1 = new DateTime().withDayOfMonth(25).withMonthOfYear(3).withYear(2012);
        de1 = new DateTime().withDayOfMonth(4).withMonthOfYear(4).withYear(2012);
        
        ds2 = new DateTime().withDayOfMonth(18).withMonthOfYear(3).withYear(2012);
        de2 = new DateTime().withDayOfMonth(4).withMonthOfYear(4).withYear(2012);
        
        List<DateTime> dtlist = new ArrayList<DateTime>();
        dtlist.add(dt);
        dtlist.add(de);
        dtlist.add(ds1);
        dtlist.add(de1);
        dtlist.add(ds2);
        dtlist.add(de2);
        
        for(int i = 0;i<dtlist.size();i+=2){
            convert(dtlist.get(i),dtlist.get(i+1));
        }
        
        
        
        
       
        
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
