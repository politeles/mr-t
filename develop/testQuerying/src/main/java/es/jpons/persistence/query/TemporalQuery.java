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
    protected Double weight = 0.5D;
    protected AllenRelation  ar;
    protected PossibilisticVTP pvp;
    
    protected List<TemporalQuery> temporalQueryList;
    
    public TemporalQuery(Session session, Object entity){
        this.session = session;
        crispCriteria = session.createCriteria(entity.getClass());
        temporalCriteria = session.createCriteria(entity.getClass());
        this.temporalQueryList = new ArrayList<TemporalQuery>();
        
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
            case meets: this.temporalCriteria = CriteriaAllenRelations.meets(this.temporalCriteria, pvp);
                break;
            case meet_by: this.temporalCriteria = CriteriaAllenRelations.meet_by(temporalCriteria, pvp);
                break;
            case overlaps: this.temporalCriteria = CriteriaAllenRelations.overlaps(temporalCriteria, pvp);
                break;
            case overlapped_by: this.temporalCriteria = CriteriaAllenRelations.overlapped_by(temporalCriteria, pvp);
                break;
            case during: this.temporalCriteria = CriteriaAllenRelations.during(temporalCriteria, pvp);
                break;
            case contains: this.temporalCriteria  = CriteriaAllenRelations.contains(temporalCriteria, pvp);
                break;
            case equal: this.temporalCriteria = CriteriaAllenRelations.equals(temporalCriteria, pvp);
                break;
            case starts: 
            case started_by:
                this.temporalCriteria = CriteriaAllenRelations.starts(temporalCriteria, pvp);
                break;
            case finishes:
            case finished_by:
                this.temporalCriteria = CriteriaAllenRelations.ends(temporalCriteria, pvp);
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
        
        
        for(QueryResult q:merge){
            q.temporalSatisfaction = 0.0D;
            
            if(ar!=null){
            switch(ar){
                case before: q.temporalSatisfaction = CriteriaAllenRelations.computeBeforeSatisfactionDegree(q.vtp, pvp);
                    break;
                    // note that the after relation is the inverse of the before:
                case after: q.temporalSatisfaction = CriteriaAllenRelations.computeBeforeSatisfactionDegree(pvp, q.vtp);
                    break;
                case meets: q.temporalSatisfaction = CriteriaAllenRelations.computeMeetsSatisfactionDegree(q.vtp, pvp);
                    break;
                case meet_by: q.temporalSatisfaction = CriteriaAllenRelations.computeMeetsSatisfactionDegree(pvp, q.vtp);
                    break;
                case overlaps: q.temporalSatisfaction = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(q.vtp, pvp);
                    break;
                case overlapped_by: q.temporalSatisfaction = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(pvp,q.vtp);
                    break;
                case during: q.temporalSatisfaction = CriteriaAllenRelations.computeDuringSatisfactionDegree(q.vtp, pvp);
                    break;
                case contains: q.temporalSatisfaction = CriteriaAllenRelations.computeContainsSatisfactionDegree(q.vtp, pvp);
                    break;
                
            }
            }
           
            q.aggregation = weight*(q.crispSatisfaction) + (1-weight)*q.temporalSatisfaction;
        }
        
        
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
    public TemporalQuery innerJoin(Object entity){
        
        
        
        
        return this;
        
        
    }
    
    
    
    /**
     * Function to create a new temporal query.
     * This is used to make cartesian products and temporal joins.
     * @param entity An entity
     * @return An instance of the temporal query object.
     */
    public TemporalQuery createTemporalQuery(Object entity){
        TemporalQuery tq = new TemporalQuery(session, entity);
        temporalQueryList.add(tq);
        return tq;
    }
    
    
    public List<QueryResult> cartesianProduct() throws TemporalException{
        List<QueryResult> queryResult = this.getList();
        if(this.temporalQueryList.size()>0){
//            List<QueryResult> queryResult = this.getList();
            
            for(TemporalQuery tq:temporalQueryList){
                if(!tq.equals(this)){
                    List<QueryResult> queryResult2 = tq.getList();
                    queryResult = mergeCartesianProduct(queryResult, queryResult2);
                    
                }
            }
            
            
        }
        return queryResult;
        
    }
    
    protected List<QueryResult> mergeCartesianProduct(List<QueryResult> qr1, List<QueryResult> qr2) throws TemporalException{
        List<QueryResult> resultList = new ArrayList<QueryResult>();
        
        
        // if there is intersection between both tuples, then, compute the time interval:
        for(int i=0;i<qr1.size();i++){
            for(int j=0;j<qr2.size();j++){
               if(CriteriaAllenRelations.computeIntersectsSatisfactionDegree(qr1.get(i).getVtp(), qr2.get(j).getVtp())>=0.5){
                   List l = new ArrayList();
                   l.add(qr1.get(i).getEntity());
                   l.add(qr2.get(j).getEntity());
                   
                   
                   QueryResult qr = new QueryResult(l);
                   qr.vtp = CriteriaAllenRelations.overlappingInterval(qr1.get(i).getVtp(), qr2.get(j).getVtp()) ;
                        
                   resultList.add(qr);
               }
            }
        }
        return resultList;
        
    }
    
    
   
}
