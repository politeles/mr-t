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
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Class for implementing the corresponding criteria for allen relations.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class CriteriaAllenRelations {
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
    
    
    public static Double computeBeforeSatisfactionDegree(PossibilisticVTP i,PossibilisticVTP j){
        Double satisfaction = 0.0D;
        
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

}
