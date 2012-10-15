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

import es.jpons.persistence.TemporalPersistenceManager;
import es.jpons.persistence.exception.TemporalException;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Class for implementing a temporal query
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class TemporalQuery {
    
    protected Session session;
    protected TemporalPersistenceManager manager;
    
    protected Criteria crispCriteria;
    protected Criteria temporalCriteria;
    protected Double weight;
    protected AllenRelation  ar;
    protected PossibilisticVTP pvp;
    
    public TemporalQuery(Session session, Object entity){
        this.session = session;
        crispCriteria = session.createCriteria(entity.getClass());
        temporalCriteria = session.createCriteria(entity.getClass());
        
    }

    public Criteria getCrispCriteria() {
        return crispCriteria;
    }

    public void setCrispCriteria(Criteria crispCriteria) {
        this.crispCriteria = crispCriteria;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public AllenRelation getAllenRelation() {
        return ar;
    }

    public void setAllenRelation(AllenRelation ar,PossibilisticVTP pvp) {
        this.ar = ar;
        this.pvp = pvp;
        createCriteria();
        
    }
    
    
    protected void createCriteria(){
        switch(ar){
            case before: this.temporalCriteria = CriteriaAllenRelations.before(this.temporalCriteria, pvp);
                            break;
            case after: this.temporalCriteria = CriteriaAllenRelations.after(this.temporalCriteria, pvp);
                break;
        }
    }
    
    public List<QueryResult> getList() throws TemporalException{
        List crispResults = null;
        List temporalResults = null;
        if(crispCriteria!=null){
            
            crispResults = crispCriteria.list();
        }
        if(temporalCriteria!=null){
            temporalResults = temporalCriteria.list();
        }
        List<QueryResult> merge = combine(crispResults, temporalResults);
        
        
//        for(int i=0;i<merge.size();i++){
//            Double sat = 0.0D;
//            switch(ar){
//                case before: sat = CriteriaAllenRelations.computeBeforeSatisfactionDegree(pvp, pvp);///TODO:por aqui
//            }
//        }
        
        
        return merge;
    }
    
    
    protected List<QueryResult> combine(List crisp,List temporal) throws TemporalException{
        
        
        List<QueryResult> mergedList = new ArrayList<QueryResult>(crisp.size());
        for (int i = 0;i<crisp.size();i++){
            Object element = crisp.get(i);
            QueryResult qr = new QueryResult(element);
            qr.setCrispSatisfaction(1D);
            mergedList.add(qr);
            }
        
    
    for(int j =0;j<temporal.size();j++){
        Object element = temporal.get(j);
        QueryResult qr = new QueryResult(element);
        qr.setTemporalSatisfaction(1D);
        
        if(mergedList.contains(qr)){
          int pos =  mergedList.indexOf(qr);
          QueryResult q = mergedList.get(pos);
          q.setTemporalSatisfaction(1D);
        }else{
            mergedList.add(qr);
        }
    }
    
    
    return mergedList;
    
    }
    
//    boolean isContained(Object element,List list) throws TemporalException{
//        boolean isContained = false;
//        try{
//        TemporalPK entityPK = manager.getPK(element);
//        
//        for(int i=0;i<list.size() &&!isContained;i++){
//            
//            TemporalPK listPK = manager.getPK(list.get(i));
//            
//            if(listPK.equals(entityPK)){
//                isContained = true;
//            }
//        }
//        
//        }catch(Exception e){
//            throw new TemporalException(e);
//        }
//        
//        return isContained;
//        
//    }
    
    
   
}
