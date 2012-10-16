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

package es.jpons.persistence.query;

import es.jpons.temporal.types.PossibilisticVTP;
import java.sql.Types;
import javassist.bytecode.analysis.Type;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.LongType;


/**
 * Class for implementing the corresponding criteria for allen relations.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class CriteriaAllenRelations {
    protected static Logger log = Logger.getLogger(CriteriaAllenRelations.class);
    /**
     * Returns a criteria for the before allen relation.
     * This models the relation:
     * record.pvp before query.pvp 
     * @param initializedCriteria an initialized instance of a criteria
     * @param pvp a possibilistic valid time period
     * @return A criteria with the before operation implemented.
     */
    public static Criteria before(Criteria initializedCriteria, PossibilisticVTP pvp){
        initializedCriteria = initializedCriteria.add(Restrictions.lt("pvp.endMP", pvp.getStartMP()));
        
        return initializedCriteria;
    }
    
    
    public static Double computeBeforeSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        Double satisfaction = 0.0;

        Double a = 0.0+ i.getEndLeft();
        Double b = 0.0+i.getEndRight();
        Double d = 0.0+i.getEndMP().getTime();
        

        Double a1 = 0.0+j.getStartLeft();
        Double b1 = 0.0+j.getStartRight();
        Double d1 = 0.0+j.getStartMP().getTime();
        if(log.isDebugEnabled()){
        log.debug("a1: " + a1 + " b1: " + b1 + " d1: " + d1);
        }
        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        x1 += (a * (d1 - a1) + a1 * d) / (a1 + a);
        y1 += -(-d1 + d - a) / (a1 + a);
  
        if (Math.abs( b - a1) >0) {
            x2 += (b * (a1 - d1) + a1 * d) / (b - a1);
            y2 += (-d1 + d + b) / (b - a1);
        }
        
        Double max = 0.0;
        if(y1 >0 && y1<=1 && y2>=0 && y2<=1){
            satisfaction += (y1>=y2)?y1:y2;
        }else{
            satisfaction = 1.0;
        }
        if(log.isDebugEnabled()){
        log.debug("a: " + a + " b: " + b + " d: " + d + " y1: "+y1 + " y2 :"+y2 + "satisfaction; "+satisfaction);
        }
        return satisfaction;
    }
    
    /**
     * Implementation of the after allen rellation.
     * @param initializedCriteria
     * @param pvp
     * @return 
     */
    public static Criteria after(Criteria initializedCriteria, PossibilisticVTP pvp){
        initializedCriteria = initializedCriteria.add(Restrictions.gt("pvp.startMP", pvp.getEndMP()));
        return initializedCriteria;
    }
    
    /**
     * Meets relation
     * @param initializedCriteria an initialized criteria
     * @param pvp a possibilistic valid time period.
     * @return  A criteria
     */
    public static Criteria meets(Criteria initializedCriteria, PossibilisticVTP pvp){
        Long left = pvp.getStartMP().getTime() - pvp.getStartLeft();
        Long right = pvp.getStartMP().getTime() + pvp.getStartRight();
        initializedCriteria = initializedCriteria.add(Restrictions.and(
                Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) >= ?",left, LongType.INSTANCE),
                 Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) <= ?",right, LongType.INSTANCE)
                
                
                ));
        
        return initializedCriteria;
    }
    
    /**
     * Compute the satisfaction degree for the allen relation  i meets j.
     * @param i the first possibilistic valid-time period
     * @param j the second possibilistic valid-time period
     * @return A satisfaction degree in the interval [0,1]
     */
    public static Double computeMeetsSatisfactionDegree(PossibilisticVTP i,PossibilisticVTP j){
        return 1.0;
    }

}
