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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the result of a query. It is stored both crisp and temporal
 * satisfaction.
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 15/10/2012 First version.
 * 30/01/2013 Modification for the cartesian product.
 *
 */
public class QueryResult {

    protected List entity;
    protected List<TemporalPK> key;
    protected PossibilisticVTP vtp;
    protected Double crispSatisfaction;
    protected Double temporalSatisfaction;
    protected Double aggregation;

    /**
     * Entity constructor
     *
     * @param entity
     * @throws TemporalException
     */
    public QueryResult(Object entity) throws TemporalException {
        this.entity = new ArrayList();
        this.key = new ArrayList<TemporalPK>();
        this.crispSatisfaction = 0D;
        this.temporalSatisfaction = 0D;
        this.aggregation = 0D;
        
        if (entity != null && isList(entity)) {
            List entities = (List) entity;
            addEntities(entities);
        } else {
            addEntity(entity);
        }




//        if (entity != null) {
//            try {
//                this.key.add(TimeUtils.getPK(entity));
//                this.vtp = TimeUtils.getValidTime(entity);
//            } catch (Exception e) {
//                throw new TemporalException(e);
//            }




//        }
    }

    
    private boolean isList(Object entity){
        if(entity==null){
            return false;
        }
        Class<?>[] interfaces = entity.getClass().getInterfaces();
        boolean found = false;
        for(int i=0;i<interfaces.length&&!found;i++){
            if(interfaces[i].isAssignableFrom(List.class)){
                found = true;
            }
        }
        return found;
        
        
    }
    
    
    private void addEntity(Object entity) throws TemporalException {

        if (entity != null) {
            this.entity.add(entity);
            try {
                this.key.add(TimeUtils.getPK(entity));
                this.vtp = TimeUtils.getValidTime(entity);
            } catch (Exception e) {
                throw new TemporalException(e);
            }

        }
    }

    /**
     * constructor for complex entities like in the case of a cartesian product
     * or an join.
     *
     * @param entities a list of entities.
     */
    private void addEntities(List entities) throws TemporalException {
        if (entities != null) {
            for (Object entityElement : entities) {
                addEntity(entityElement);
            }
        } else {
            throw new TemporalException(new NullPointerException());
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
        if (this.entity != null && this.entity.size() > 0) {
            return this.entity.get(0);
        }
        return null;
    }

    public PossibilisticVTP getVtp() {
        return vtp;
    }

    public TemporalPK getKey() {
        if (key != null && key.size() > 0) {
            return key.get(0);
        }
        return null;
    }
    
    public List<TemporalPK> getKeys(){
        return this.key;
    }
    
    public List getEntities(){
        return this.entity;
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
        boolean areEquals = true;
        if (this.key != null && this.key.size() > 0 && other.key != null && other.key.size() > 0) {
            for (int i = 0; i < this.key.size() && areEquals; i++) {
                for (int j = 0; j < other.key.size() && areEquals; j++) {
                    if (this.key.get(i).getId() != other.key.get(j).getId() && this.key.get(i).getVid() == other.key.get(j).getVid()) {
                        areEquals = false;
                    }
                }
            }
        }


        return false;
    }
}
