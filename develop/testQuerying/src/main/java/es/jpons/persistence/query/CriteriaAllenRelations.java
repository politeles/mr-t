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
        Double d = 0.0+i.getEndMP();
        

        Double a1 = 0.0+j.getStartLeft();
        Double b1 = 0.0+j.getStartRight();
        Double d1 = 0.0+j.getStartMP();
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
        Long left = pvp.getStartMP() - pvp.getStartLeft();
        Long right = pvp.getStartMP() + pvp.getStartRight();
        initializedCriteria = initializedCriteria.add(Restrictions.and(
                Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) >= ?",left, LongType.INSTANCE),
                 Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) <= ?",right, LongType.INSTANCE)
                
                
                ));
        
        return initializedCriteria;
    }
    
    
    
    public static Criteria meet_by(Criteria initializedCriteria, PossibilisticVTP pvp){
        Long left = pvp.getEndMP() - pvp.getEndLeft();
        Long right = pvp.getEndMP() + pvp.getEndRight();
        initializedCriteria = initializedCriteria.add(Restrictions.and(
                Restrictions.sqlRestriction(
                "( {alias}.startMP + {alias}.startLeft ) >= ?",left, LongType.INSTANCE),
                 Restrictions.sqlRestriction(
                "( {alias}.startMP + {alias}.startLeft ) <= ?",right, LongType.INSTANCE)
                
                
                ));
        return initializedCriteria;
    }
    
    
    public static Criteria overlaps(Criteria initializedCriteria, PossibilisticVTP pvp){
        Long d1left = pvp.getStartMP();
        Long d1Right = pvp.getEndMP();
        
        
        initializedCriteria = initializedCriteria.add(
                Restrictions.and(
                    Restrictions.sqlRestriction("({alias}.startMP + {alias}.startRight ) < ?", d1left,LongType.INSTANCE),
                    Restrictions.sqlRestriction(" ( {alias}.endMP - {alias}.endLeft ) < ? ",d1left,LongType.INSTANCE),
                    Restrictions.sqlRestriction(" ( {alias}.endMP + {alias}.endRight) < ?",d1Right,LongType.INSTANCE)
                
                )
                
                );
        
        return initializedCriteria;
    }
    
    /**
     * Compute the satisfaction degree for the allen relation  i meets j.
     * @param i the first possibilistic valid-time period
     * @param j the second possibilistic valid-time period
     * @return A satisfaction degree in the interval [0,1]
     */
    public static Double computeMeetsSatisfactionDegree(PossibilisticVTP i,PossibilisticVTP j){
        return computeIntersections(i.getEndLeft(),i.getEndRight(),i.getEndMP(),j.getStartLeft(),j.getStartRight(),j.getStartMP());
    }
    
    
    
    public static Double computeOverlapsSatisfactionDegree(PossibilisticVTP i,PossibilisticVTP j){
        Double a,b,c,max;
        
        a = computeIntersectionLt(i.getStartLeft(), i.getStartRight(),i.getStartMP(), j.getStartLeft(), j.getStartMP());
        max = a;
        
        b = computeIntersectionGt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getStartLeft(),j.getStartRight(), j.getStartMP());
        max = (b>max)?b:max;
        
        c = computeIntersectionLt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(),j.getEndMP());
        max = (c>max)?c:max;
        
        return max;
    }
    
    
    
    
    /**
     * Computes the intersection between two triangles
     * @param ai
     * @param bi
     * @param di
     * @param a1j
     * @param b1j
     * @param d1j
     * @return 
     */
    protected static Double computeIntersections(Long ai,Long bi,Long di, Long a1j,Long b1j, Long d1j){
        Double a = 0.0 + ai;
        Double b = 0.0 +bi;
        Double d = 0.0 + di;
        
        Double a1 = 0.0+a1j;
        Double b1 = 0.0+b1j;
        Double d1 = 0.0+d1j;
       
         // intersection li, ld1
        Double x1;
        Double y1;
        
        x1 = -(a1*d -a*d1)/(a-a1);
        y1 = -(-d1+d+a1-a)/(a-a1);

        // intersection li, li1
        
        Double x2 ;
        Double y2 ;
        
        x2 = (a*d1+b1*d)/(b1+a);
        y2= -(-d1+d-b1-a)/(b1+a);
        
        
        //intersection ld, li1
        Double x3 ;
        Double y3 ;
        
        x3 = (b*d1+a1*d)/(b+a1);
        y3 = (-d1+d+b+a1)/(b+a1);
        //intersection ld, ld1
        
        Double x4;
        Double y4 ;
        
        x4 = -(b1*d-b*d1)/(b-b1);
        y4 = (-d1+d-b1+b)/(b-b1);
        
        // look for the intersection:
        Double max = 0.0;
        if(x1>= (d1-a1) && x1 <= (d1+b1) && y1>=0 && y1<=1){
            max = y1;
        }
        
        if(x2>= (d1-a1) && x2 <= (d1+b1) && y2>=0 && y2<=1){
            max = (y2>max)?y2:max;
        }
        
         if(x3>= (d1-a1) && x3 <= (d1+b1) && y3>=0 && y3<=1){
            max = (y3>max)?y3:max;
        }
          if(x4>= (d1-a1) && x4 <= (d1+b1) && y4>=0 && y4<=1){
            max = (y4>max)?y4:max;
        }
        
         if(log.isDebugEnabled()){
            log.debug("max: "+ max+" x1:" + x1 + " y1: "+y1 + " x2 "+x2+ " y2 "+y2 + "x3 "+x3+ " y3 "+ y3 +" x4 "+x4 + " y4 " + y4);
        }
        
        return max;
    }
    
    protected static Double computeIntersectionLt(Long ai,Long bi,Long di,Long aj, Long dj ){
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0+bi;
        Double d = 0.0+di;
        
        Double a1 = 0.0+ aj;
        Double d1 = 0.0+dj;
        
         Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        x1 += (a * (d1 - a1) + a1 * d) / (a1 + a);
        y1 += -(-d1 + d - a) / (a1 + a);
  
        if (Math.abs( b - a1) >0) {
            x2 += (b * (a1 - d1) + a1 * d) / (b - a1);
            y2 += (-d1 + d + b) / (b - a1);
        }
                
       if(x1 >= (d1-a1)&& x1<=(d1) && y1>=0 && y1<=1){
           max = y1;
       }
       
       if(x2 >= (d1-a1)&& x2<=(d1) && y2>=0 && y2<=1){
           max = (max>y2)?max:y2;
       }
        return max;
    }
    
    protected static Double computeIntersectionLte(Long ai,Long bi,Long di,Long aj, Long bj,Long dj ){
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0+bi;
        Double d = 0.0+di;
        
        Double a1 = 0.0+ aj;
        Double b1 = 0.0+bj;
        Double d1 = 0.0+dj;
        
         Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
         
         x1 = (a*d1+b1*d)/(b1+a);
         y1= -(-d1+d-b1-a)/(b1+a);
         
         if((b-b1)>0){
         x2 = -(b1*d-b*d1)/(b-b1);
         y2= (-d1+d-b1+b)/(b-b1);
         }
         
         if(x1 >= d1 && x1<= (d1+b1) && y1>=0 && y1<=1){
             max = y1;
         }
         if(x2 >= d1 && x2<= (d1+b1) && y2>=0 && y2<=1){
             max = (max>y2)?max:y2;
         }
     
         return max;
    }
    
    protected static Double computeIntersectionGt(Long ai,Long bi,Long di,Long aj,Long bj,Long dj){
        Double max = 0.0;
         Double a = 0.0 + ai;
        Double b = 0.0+bi;
        Double d = 0.0+di;
        
        Double a1 = 0.0+ aj;
        Double b1 = 0.0+bj;
        Double d1 = 0.0+dj;
        
        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        if(a-b1>0){
        x1 = -(a*(-d1-b1)+b1*d)/(a-b1);
        y1 = -(-d1+d-a)/(a-b1);
        }
        
        x2= (b*(d1+b1)+b1*d)/(b1+b);
        y2= (-d1+d+b)/(b1+b);
        
         if(x1 >= d1 && x1<= (d1+b1) && y1>=0 && y1<=1){
             max = y1;
         }
         if(x2 >= d1 && x2<= (d1+b1) && y2>=0 && y2<=1){
             max = (max>y2)?max:y2;
         }
        
        
        
        return max;
    }
    
    
     protected static Double computeIntersectionGte(Long ai,Long bi,Long di,Long aj,Long bj,Long dj){
        Double max = 0.0;
         Double a = 0.0 + ai;
        Double b = 0.0+bi;
        Double d = 0.0+di;
        
        Double a1 = 0.0+ aj;
        Double b1 = 0.0+bj;
        Double d1 = 0.0+dj;
        
        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        if(a-a1>0){
        x1 = -(a1*d-a*d1)/(a-11);
        y1 = -(-d1+d+a1-a)/(a-a1);
        }
        
        x2= (b*d1+a1*d)/(b1+a1);
        y2= (-d1+d+b+a1)/(b1+a1);
        
         if(x1 >= (d1-a1) && x1<= d1 && y1>=0 && y1<=1){
             max = y1;
         }
         if(x2 >= (d1-a1) && x2<= d1 && y2>=0 && y2<=1){
             max = (max>y2)?max:y2;
         }
        return max;
    }
    
    

}
