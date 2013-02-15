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
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.LongType;

/**
 * Class for implementing the corresponding criteria for allen relations.
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 15/10/2012
 *
 */
public class CriteriaAllenRelations {

    protected static Logger log = Logger.getLogger(CriteriaAllenRelations.class);

    /**
     * Returns a criteria for the before allen relation. This models the
     * relation: record.pvp before query.pvp
     *
     * @param initializedCriteria an initialized instance of a criteria
     * @param pvp a possibilistic valid time period
     * @return A criteria with the before operation implemented.
     */
    public static Criteria before(Criteria initializedCriteria, PossibilisticVTP pvp) {
        initializedCriteria = initializedCriteria.add(Restrictions.lt("pvp.endMP", pvp.getStartMP()));

        return initializedCriteria;
    }

    public static Double computeBeforeSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        Double satisfaction = 0.0;
        boolean inside = false;
        
        if(i.getEndMP() < j.getStartMP()){
            inside = true;
        }
        
        
//
//        Double a = 0.0 + i.getEndLeft();
//        Double b = 0.0 + i.getEndRight();
//        Double d = 0.0 + i.getEndMP();
//
//
//        Double a1 = 0.0 + j.getStartLeft();
//        Double b1 = 0.0 + j.getStartRight();
//        Double d1 = 0.0 + j.getStartMP();
//        if (log.isDebugEnabled()) {
//            log.debug("a1: " + a1 + " b1: " + b1 + " d1: " + d1);
//        }
//        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
//        x1 += (a * (d1 - a1) + a1 * d) / (a1 + a);
//        y1 += -(-d1 + d - a) / (a1 + a);
//
//        if (Math.abs(b - a1) > 0) {
//            x2 += (b * (a1 - d1) + a1 * d) / (b - a1);
//            y2 += (-d1 + d + b) / (b - a1);
//        }
//
//        Double max = 0.0;
//        if (y1 > 0 && y1 <= 1 && y2 >= 0 && y2 <= 1) {
//            satisfaction += (y1 >= y2) ? y1 : y2;
//        } else {
//            satisfaction = 1.0;
//        }
//        if (log.isDebugEnabled()) {
//            log.debug("a: " + a + " b: " + b + " d: " + d + " y1: " + y1 + " y2 :" + y2 + "satisfaction; " + satisfaction);
//        }
        
        satisfaction = computeIntersectionLt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getStartLeft(), j.getStartMP());
        if(inside && satisfaction ==0){
            satisfaction = 1.0;
        }
        
        return satisfaction;
    }

    /**
     * Implementation of the after allen rellation.
     *
     * @param initializedCriteria
     * @param pvp
     * @return
     */
    public static Criteria after(Criteria initializedCriteria, PossibilisticVTP pvp) {
        initializedCriteria = initializedCriteria.add(Restrictions.gt("pvp.startMP", pvp.getEndMP()));
        return initializedCriteria;
    }

    /**
     * Meets relation
     *
     * @param initializedCriteria an initialized criteria
     * @param pvp a possibilistic valid time period.
     * @return A criteria
     */
    public static Criteria meets(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long left = pvp.getStartMP() - pvp.getStartLeft();
        Long right = pvp.getStartMP() + pvp.getStartRight();
        initializedCriteria = initializedCriteria.add(Restrictions.and(
                Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) >= ?", left, LongType.INSTANCE),
                Restrictions.sqlRestriction(
                "( {alias}.endMP + {alias}.endLeft ) <= ?", right, LongType.INSTANCE)));

        return initializedCriteria;
    }

    public static Criteria meet_by(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long left = pvp.getEndMP() - pvp.getEndLeft();
        Long right = pvp.getEndMP() + pvp.getEndRight();
        initializedCriteria = initializedCriteria.add(Restrictions.and(
                Restrictions.sqlRestriction(
                "( {alias}.startMP + {alias}.startLeft ) >= ?", left, LongType.INSTANCE),
                Restrictions.sqlRestriction(
                "( {alias}.startMP + {alias}.startLeft ) <= ?", right, LongType.INSTANCE)));
        return initializedCriteria;
    }

    /**
     * Implements the overlaps based on (i+ < j+) ^(i+ > j+) ^(i+<j+)
     *
     * @param initializedCriteria
     * @param pvp
     * @return
     */
    public static Criteria overlaps(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long d1left = pvp.getStartMP();
        Long d1Right = pvp.getEndMP();


        initializedCriteria = initializedCriteria.add(
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP + {alias}.startRight ) < ?", d1left, LongType.INSTANCE),
                Restrictions.sqlRestriction(" ( {alias}.endMP - {alias}.endLeft ) < ? ", d1left, LongType.INSTANCE),
                Restrictions.sqlRestriction(" ( {alias}.endMP + {alias}.endRight) < ?", d1Right, LongType.INSTANCE)));

        return initializedCriteria;
    }

    /**
     * Implements the overlapped_by criteria
     *
     * @param initializedCriteria
     * @param pvp
     * @return
     */
    public static Criteria overlapped_by(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long d1left = pvp.getStartMP();
        Long d1Right = pvp.getEndMP();


        initializedCriteria = initializedCriteria.add(
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP - {alias}.startLeft ) > ?", d1left, LongType.INSTANCE),
                Restrictions.sqlRestriction(" ( {alias}.startMP + {alias}.startRight ) < ? ", d1left, LongType.INSTANCE),
                Restrictions.sqlRestriction(" ( {alias}.endMP - {alias}.endLeft) > ?", d1Right, LongType.INSTANCE)));

        return initializedCriteria;
    }

    /**
     * Implements the during criteria
     *
     * @param initializedCriteria
     * @param pvp
     * @return
     */
    public static Criteria during(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long jstart = pvp.getStartMP();
        Long jright = pvp.getEndMP() + pvp.getEndRight();
        Long jleft = pvp.getStartMP() - pvp.getStartLeft();
        Long jend = pvp.getEndMP();

        initializedCriteria = initializedCriteria.add(
                Restrictions.or(
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP ) > ?", jstart, LongType.INSTANCE),
                Restrictions.sqlRestriction("{alias}.endMP <= ?", jright, LongType.INSTANCE)),
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP ) >= ?", jleft, LongType.INSTANCE),
                Restrictions.sqlRestriction("{alias}.endMP < ?", jend, LongType.INSTANCE))));

        return initializedCriteria;

    }

    /**
     * Implements the contains
     *
     * @param initializedCriteria
     * @param pvp
     * @return
     */
    public static Criteria contains(Criteria initializedCriteria, PossibilisticVTP pvp) {
        Long jstart = pvp.getStartMP();
        Long jright = pvp.getStartMP() + pvp.getStartRight();
        Long jleft = pvp.getEndMP() - pvp.getEndLeft();
        Long jend = pvp.getEndMP();

        initializedCriteria = initializedCriteria.add(
                Restrictions.or(
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP ) < ?", jstart, LongType.INSTANCE),
                Restrictions.sqlRestriction("{alias}.endMP >= ?", jleft, LongType.INSTANCE)),
                Restrictions.and(
                Restrictions.sqlRestriction("({alias}.startMP ) <= ?", jright, LongType.INSTANCE),
                Restrictions.sqlRestriction("{alias}.endMP > ?", jend, LongType.INSTANCE))));

        return initializedCriteria;

    }

    public static Criteria equals(Criteria initializedCriteria, PossibilisticVTP pvp) {

        initializedCriteria = initializedCriteria.add(
                Restrictions.and(
                Restrictions.or(
                Restrictions.sqlRestriction("({alias}.startMP + {alias}.startRight ) <= ?", pvp.getStartMP() - pvp.getStartLeft(), LongType.INSTANCE),
                Restrictions.sqlRestriction("({alias}.startMP - {alias}.startLeft ) >= ?", pvp.getStartMP() + pvp.getStartRight(), LongType.INSTANCE)),
                Restrictions.or(
                Restrictions.sqlRestriction("({alias}.endMP + {alias}.endRight ) <= ?", pvp.getEndMP() - pvp.getEndLeft(), LongType.INSTANCE),
                Restrictions.sqlRestriction("({alias}.endMP - {alias}.endLeft ) >= ?", pvp.getEndMP() + pvp.getEndRight(), LongType.INSTANCE))));

        return initializedCriteria;
    }

    public static Criteria starts(Criteria initializedCriteria, PossibilisticVTP pvp) {

        initializedCriteria = initializedCriteria.add(
                Restrictions.or(
                Restrictions.sqlRestriction("({alias}.startMP + {alias}.startRight ) <= ?", pvp.getStartMP() - pvp.getStartLeft(), LongType.INSTANCE),
                Restrictions.sqlRestriction("({alias}.startMP - {alias}.startLeft ) >= ?", pvp.getStartMP() + pvp.getStartRight(), LongType.INSTANCE)));

        return initializedCriteria;
    }

    public static Criteria ends(Criteria initializedCriteria, PossibilisticVTP pvp) {

        initializedCriteria = initializedCriteria.add(
                Restrictions.or(
                Restrictions.sqlRestriction("({alias}.endMP + {alias}.endRight ) <= ?", pvp.getEndMP() - pvp.getEndLeft(), LongType.INSTANCE),
                Restrictions.sqlRestriction("({alias}.endMP - {alias}.endLeft ) >= ?", pvp.getEndMP() + pvp.getEndRight(), LongType.INSTANCE)));

        return initializedCriteria;
    }

    /**
     * Compute the satisfaction degree for the allen relation i meets j.
     *
     * @param i the first possibilistic valid-time period
     * @param j the second possibilistic valid-time period
     * @return A satisfaction degree in the interval [0,1]
     */
    public static Double computeMeetsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        return computeIntersections(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
    }

    public static Double computeOverlapsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        boolean inside = false;

        if ((i.getStartMP() + i.getStartRight() < j.getStartMP())
                && (i.getEndMP() - i.getEndLeft() > j.getStartMP())
                && (i.getEndMP() + i.getEndRight() < j.getEndMP())) {
            inside = true;
        }

        Double a, b, c, max;

        a = computeIntersectionLt(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartMP());
        max = a;

        b = computeIntersectionGt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        max = (b > max) ? b : max;

        c = computeIntersectionLt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndMP());
        max = (c > max) ? c : max;

        if (inside && max == 0) {
            max = 1.0;
        }

        return max;
    }

    public static Double computeContainsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {

        boolean inside = false;

        if ((i.getStartMP() < j.getStartMP() && i.getEndMP() >= (j.getEndMP() - j.getEndLeft()))
                || (i.getStartMP() <= j.getStartMP() + j.getStartRight()) && (i.getEndMP() > j.getEndMP())) {
            inside = true;
        }


        Double min = 1.0, max1 = 0.0, max2 = 0.0, a, b, c, d;

        a = computeIntersectionLt(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartMP());
        b = computeIntersectionGte(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndRight(), j.getEndMP());

        max1 = (a > b) ? a : b;

        c = computeIntersectionLte(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        d = computeIntersectionGt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndRight(), j.getEndMP());

        max2 = (c > d) ? c : d;

        min = (max1 < max2) ? max1 : max2;
        if (inside && min == 0) {
            min = 1.0;
        }



        return min;
    }

    public static Double computeDuringSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        boolean inside = false;
        if ((i.getStartMP() > j.getStartMP() && i.getEndMP() <= (j.getEndMP() + j.getEndRight()))
                || (i.getStartMP() >= (j.getStartMP() - j.getStartLeft()) && i.getEndMP() < j.getEndMP())) {
            inside = true;
        }

        Double min = 1.0, max1 = 0.0, max2 = 0.0, a, b, c, d;


        a = computeIntersectionGt(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        b = computeIntersectionLte(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndRight(), j.getEndMP());

        max1 = (a > b) ? a : b;

        c = computeIntersectionGte(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        d = computeIntersectionLt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndMP());

        max2 = (c > d) ? c : d;

        min = (max1 < max2) ? max1 : max2;
        if (inside && min == 0) {
            min = 1.0;
        }


        return min;
    }

    public static Double computeEqualsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        Double min, a, b;

        a = computeIntersections(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        b = computeIntersections(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndRight(), j.getEndMP());

        min = (a < b) ? a : b;

        return min;
    }

    public static Double computeStartsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        Double res;
        res = computeIntersections(i.getStartLeft(), i.getStartRight(), i.getStartMP(), j.getStartLeft(), j.getStartRight(), j.getStartMP());
        return res;
    }

    public static Double computeFinishesSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j) {
        Double res;
        res = computeIntersections(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndRight(), j.getEndMP());
        return res;
    }
    
    /**
     * Intersection of two possibilistic valid time points.
     * 
     * @param i
     * @param j
     * @return 
     */
    public static double computeIntersectsSatisfactionDegree(PossibilisticVTP i, PossibilisticVTP j){
        Double res,a,b;
       a = computeIntersectionLt(i.getStartLeft(),i.getStartRight(),i.getStartMP(),j.getStartLeft(),j.getStartMP());
       b = computeIntersectionLt(j.getStartLeft(),j.getStartRight(),j.getStartMP(),i.getStartLeft(),i.getStartMP());
       
       res = (a<b)?a:b;
       
       return res;
    }
    
    /**
     * Computes de overlapping interval for two possibilistic valid-time points
     * @param i
     * @param j
     * @return 
     */
   public static PossibilisticVTP overlappingInterval(PossibilisticVTP i, PossibilisticVTP j){
       PossibilisticVTP result = new PossibilisticVTP();
       // 1st step: compute the lower bound:
       Double beforeij = computeIntersectionLt(i.getStartLeft(),i.getStartRight(),i.getStartMP(),j.getStartLeft(),j.getStartMP());
       Double beforeji = computeIntersectionLt(j.getStartLeft(), j.getStartRight(), j.getStartMP(), i.getStartLeft(), i.getStartMP());
       
       if(beforeij > beforeji ){
           // i before j holds, then j should be taken as the lower bound:
           result.setStartDate(j.getStartDate());
           result.setStartLeft(j.getStartLeft());
           result.setStartRight(j.getStartRight());
       }else{
           // j before i holds then i should be taken as the lower bound:
           result.setStartDate(i.getStartDate());
           result.setStartLeft(i.getStartLeft());
           result.setStartRight(i.getStartRight());
       }
       
       //2nd step: compute the higher bound:
       beforeij = computeIntersectionLt(i.getEndLeft(), i.getEndRight(), i.getEndMP(), j.getEndLeft(), j.getEndMP());
       beforeji = computeIntersectionLt(j.getEndLeft(), j.getEndRight(), j.getEndMP(), i.getEndLeft(),i.getEndMP());
       
       if(beforeij > beforeji){
           //i before j holds, then i should be thake as the higher bound:
           result.setEndDate(i.getEndDate());
           result.setEndLeft(i.getEndLeft());
           result.setEndRight(i.getEndRight());
       } else{
           result.setEndDate(j.getEndDate());
           result.setEndLeft(j.getEndLeft());
           result.setEndRight(j.getEndRight());
       }
       
       
       
       
       
       
       
       return result;
       
       
   }

    /**
     * Computes the intersection between two triangles
     *
     * @param ai
     * @param bi
     * @param di
     * @param a1j
     * @param b1j
     * @param d1j
     * @return
     */
    protected static Double computeIntersections(Long ai, Long bi, Long di, Long a1j, Long b1j, Long d1j) {
        Double a = 0.0 + ai;
        Double b = 0.0 + bi;
        Double d = 0.0 + di;

        Double a1 = 0.0 + a1j;
        Double b1 = 0.0 + b1j;
        Double d1 = 0.0 + d1j;

        // intersection li, ld1
        Double x1;
        Double y1;

        x1 = -(a1 * d - a * d1) / (a - a1);
        y1 = -(-d1 + d + a1 - a) / (a - a1);

        // intersection li, li1

        Double x2;
        Double y2;

        x2 = (a * d1 + b1 * d) / (b1 + a);
        y2 = -(-d1 + d - b1 - a) / (b1 + a);


        //intersection ld, li1
        Double x3;
        Double y3;

        x3 = (b * d1 + a1 * d) / (b + a1);
        y3 = (-d1 + d + b + a1) / (b + a1);
        //intersection ld, ld1

        Double x4;
        Double y4;

        x4 = -(b1 * d - b * d1) / (b - b1);
        y4 = (-d1 + d - b1 + b) / (b - b1);

        // look for the intersection:
        Double max = 0.0;
        if (x1 >= (d1 - a1) && x1 <= (d1 + b1) && y1 >= 0 && y1 <= 1) {
            max = y1;
        }

        if (x2 >= (d1 - a1) && x2 <= (d1 + b1) && y2 >= 0 && y2 <= 1) {
            max = (y2 > max) ? y2 : max;
        }

        if (x3 >= (d1 - a1) && x3 <= (d1 + b1) && y3 >= 0 && y3 <= 1) {
            max = (y3 > max) ? y3 : max;
        }
        if (x4 >= (d1 - a1) && x4 <= (d1 + b1) && y4 >= 0 && y4 <= 1) {
            max = (y4 > max) ? y4 : max;
        }

        if (log.isDebugEnabled()) {
            log.debug("max: " + max + " x1:" + x1 + " y1: " + y1 + " x2 " + x2 + " y2 " + y2 + "x3 " + x3 + " y3 " + y3 + " x4 " + x4 + " y4 " + y4);
        }

        return max;
    }

    protected static Double computeIntersectionLt(Long ai, Long bi, Long di, Long aj, Long dj) {
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0 + bi;
        Double d = 0.0 + di;

        Double a1 = 0.0 + aj;
        Double d1 = 0.0 + dj;

        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        x1 += (a * (d1 - a1) + a1 * d) / (a1 + a);
        y1 += -(-d1 + d - a) / (a1 + a);

        if (Math.abs(b - a1) > 0) {
            x2 += (b * (a1 - d1) + a1 * d) / (b - a1);
            y2 += (-d1 + d + b) / (b - a1);
        }

        if (x1 >= (d1 - a1) && x1 <= (d1) && y1 >= 0 && y1 <= 1) {
            max = y1;
        }

        if (x2 >= (d1 - a1) && x2 <= (d1) && y2 >= 0 && y2 <= 1) {
            max = (max > y2) ? max : y2;
        }
        return max;
    }

    protected static Double computeIntersectionLte(Long ai, Long bi, Long di, Long aj, Long bj, Long dj) {
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0 + bi;
        Double d = 0.0 + di;

        Double a1 = 0.0 + aj;
        Double b1 = 0.0 + bj;
        Double d1 = 0.0 + dj;

        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;

        x1 = (a * d1 + b1 * d) / (b1 + a);
        y1 = -(-d1 + d - b1 - a) / (b1 + a);

        if ((b - b1) > 0) {
            x2 = -(b1 * d - b * d1) / (b - b1);
            y2 = (-d1 + d - b1 + b) / (b - b1);
        }

        if (x1 >= d1 && x1 <= (d1 + b1) && y1 >= 0 && y1 <= 1) {
            max = y1;
        }
        if (x2 >= d1 && x2 <= (d1 + b1) && y2 >= 0 && y2 <= 1) {
            max = (max > y2) ? max : y2;
        }

        return max;
    }

    protected static Double computeIntersectionGt(Long ai, Long bi, Long di, Long aj, Long bj, Long dj) {
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0 + bi;
        Double d = 0.0 + di;

        Double a1 = 0.0 + aj;
        Double b1 = 0.0 + bj;
        Double d1 = 0.0 + dj;

        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        if (a - b1 > 0) {
            x1 = -(a * (-d1 - b1) + b1 * d) / (a - b1);
            y1 = -(-d1 + d - a) / (a - b1);
        }

        x2 = (b * (d1 + b1) + b1 * d) / (b1 + b);
        y2 = (-d1 + d + b) / (b1 + b);

        if (x1 >= d1 && x1 <= (d1 + b1) && y1 >= 0 && y1 <= 1) {
            max = y1;
        }
        if (x2 >= d1 && x2 <= (d1 + b1) && y2 >= 0 && y2 <= 1) {
            max = (max > y2) ? max : y2;
        }



        return max;
    }

    protected static Double computeIntersectionGte(Long ai, Long bi, Long di, Long aj, Long bj, Long dj) {
        Double max = 0.0;
        Double a = 0.0 + ai;
        Double b = 0.0 + bi;
        Double d = 0.0 + di;

        Double a1 = 0.0 + aj;
        Double b1 = 0.0 + bj;
        Double d1 = 0.0 + dj;

        Double y1 = 0.0, y2 = 0.0, x1 = 0.0, x2 = 0.0;
        if (a - a1 > 0) {
            x1 = -(a1 * d - a * d1) / (a - 11);
            y1 = -(-d1 + d + a1 - a) / (a - a1);
        }

        x2 = (b * d1 + a1 * d) / (b1 + a1);
        y2 = (-d1 + d + b + a1) / (b1 + a1);

        if (x1 >= (d1 - a1) && x1 <= d1 && y1 >= 0 && y1 <= 1) {
            max = y1;
        }
        if (x2 >= (d1 - a1) && x2 <= d1 && y2 >= 0 && y2 <= 1) {
            max = (max > y2) ? max : y2;
        }
        return max;
    }
}
