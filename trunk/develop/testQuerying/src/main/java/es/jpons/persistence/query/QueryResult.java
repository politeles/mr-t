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

import es.jpons.persistence.TimeUtils;
import es.jpons.persistence.exception.TemporalException;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;

/**
 * Represents the result of a query.
 * It is stored both crisp and temporal satisfaction.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class QueryResult {
    protected Object entity;
    protected TemporalPK key;
    protected PossibilisticVTP vtp;
    protected Double crispSatisfaction;
    protected Double temporalSatisfaction;
    protected Double aggregation;
    

    public QueryResult(Object entity) throws TemporalException {
        this.entity = entity;
        if(entity!=null){
            try{
            this.key = TimeUtils.getPK(entity);
            this.vtp = TimeUtils.getValidTime(entity);
            }catch(Exception e){
                throw new TemporalException(e);
            }
            
        }
    }

    public Double getCrispSatisfaction() {
        return crispSatisfaction;
    }

    public void setCrispSatisfaction(Double crispSatisfaction) {
        this.crispSatisfaction = crispSatisfaction;
    }

    public Double getTemporalSatisfaction() {
        return temporalSatisfaction;
    }

    public void setTemporalSatisfaction(Double temporalSatisfaction) {
        this.temporalSatisfaction = temporalSatisfaction;
    }

    public Double getAggregation() {
        return aggregation;
    }

    public void setAggregation(Double aggregation) {
        this.aggregation = aggregation;
    }

    public Object getEntity() {
        return entity;
    }

    public PossibilisticVTP getVtp() {
        return vtp;
    }

    public TemporalPK getKey() {
        return key;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.key != null ? this.key.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QueryResult other = (QueryResult) obj;
        if (this.key.getId() == other.key.getId() && (this.key.getVid() == other.key.getVid())) {
            return true;
        }
        return false;
    }
    
    
    
    
    
    

}
