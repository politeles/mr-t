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

package es.jpons.persistence;

import es.jpons.persistence.constants.OpenInterval;
import es.jpons.persistence.exception.TemporalInsertException;
import es.jpons.persistence.util.TemporalHibernateUtil;
import es.jpons.temporal.types.PossibilisticVTP;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.Instant;


/**
 * Temporal Persistence Manager.
 * This class implements all the persistence operations for a temporal database.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 04/10/2012
 * 
 */
public class TemporalPersistenceManager {
    
    protected static Session session;
    protected static TemporalPersistenceManager manager=null;
    protected static Logger log = LogManager.getLogger(TemporalPersistenceManager.class.getName());

    public static Session getSession() {
        return session;
    }
   
    

    protected TemporalPersistenceManager() {
        
        
    }
    /**
     * Static function to get an instance.
     * @param prop A properties file with the hibernate configuration.
     * @param annotatedClasses A list with the annotated persistence classes.
     * @return An instance of the persistence manager.
     */
    public static TemporalPersistenceManager getInstance(Properties prop, List<Class> annotatedClasses){
        if(manager==null){
            session = TemporalHibernateUtil.getSession(prop, annotatedClasses);
            manager = new TemporalPersistenceManager();
        }
        return manager;
    }
    /**
     * Determines if the given entity is a valid-time object or not.
     * @param entity The entity to persist.
     * @return True if the entity is a valid-time object, false otherwise.
     */
    protected PossibilisticVTP getValidTime(Object entity) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        Class<?> c = entity.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        PossibilisticVTP validTime = null;
        boolean found = false;
        for(int i = 0;i<declaredFields.length &&!found;i++){
            if(declaredFields[i].getType().equals(PossibilisticVTP.class)){
                found = true;
//                validTime = (PossibilisticVTP) declaredFields[i].get(entity);
                String fieldName =  declaredFields[i].getName();
                fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                Class [] noparams = {};
                Object invoke = entity.getClass().getMethod(fieldName, new Class[]{}).invoke(entity, null);
                validTime = (PossibilisticVTP) invoke;
            }            
        }
        return validTime;
    }
    
   
    
    
    
    
    
    
    /**
     * Persist the given transient temporal instance, assigning a generated identifier.
     * If the object is a valid-time object, then the persistence algorithm is
     * the following:
     * <ul>
     * <li>If the item does overlap with any existing items, then reject the insertion. </li>
     * <li>If the item does not overlap any existing items, then insert.</li>
     * <li>If exist any open tuple, then call modify.</li>
     * </ul>
     * 
     * 
     * 
     * @param entity the object to persist.
     * @return The generated identifier.
     * @throws HibernateException In case of error.
     * @throws TemporalInsertException In case of error when inserting: The interval does overlaps or during any other existing valid time object.
     *  
     */
    public Serializable save(Object entity) throws HibernateException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, TemporalInsertException{
        //retrieve whether the object is a valid-time entity or not:
      Serializable generatedId = null;
      PossibilisticVTP validTime = getValidTime(entity);
        if(validTime!=null){
            Criteria criteria = session.createCriteria(entity.getClass());
            criteria = criteriaInsert(criteria, validTime);
            List list = criteria.list();
            if(list.size()>0){
                // the list has some elements, and the insertion is rejected.
            
               log.debug("Insertion rejected");
               throw new TemporalInsertException("Insertion Rejected: The valid time overlaps or during any other valid time");
               
               
            }else{
                log.debug("Insertion done");
                generatedId = session.save(entity);
            }
            //            criteria.add(Restrictions.)
            //session.
        }else{
            generatedId = session.save(entity);
        }
        return generatedId;
        
        
    }
    /**
     * Function that stablishes the constrains for the temporal insertion.
     * @param c An initialized criteria object.
     * @param validTime The valid time to intert
     * @return  A criteria to query the database.
     */
    protected Criteria criteriaInsert(Criteria c,PossibilisticVTP validTime){
        
        
        if(c==null){
            return null;
        }
        c = c.add(
                Restrictions.and(
                Restrictions.gt("pvp.startMP", validTime.getStartMP())
                ,
                Restrictions.or(
                Restrictions.and(Restrictions.lt("pvp.startMP", validTime.getEndMP()), Restrictions.gt("pvp.endMP", validTime.getEndMP())),
                Restrictions.lt("pvp.endMP", validTime.getEndMP())
                )
                
                )
                );
                
                return c;
    }
    /**
     * Function for release the connection.
     * @return 
     */
    public Connection close(){
        return TemporalPersistenceManager.session.close();
    }
/**
 * Starts a new transaction
 * @return 
 */
    public Transaction beginTransaction(){
        return session.beginTransaction();
    }
    
    
    public PossibilisticVTP closeR(PossibilisticVTP toClose,PossibilisticVTP newVtp){
        if(toClose.getSide().compareTo(OpenInterval.UC)==0){
            DateTime startmp = new DateTime(newVtp.getStartMP());
//            
//            DateTime lefts = startmp.plus( new Instant(newVtp.getStartLeft()));
//            if(newVtp.getStartMP()> )
        }
        
        
        return toClose;
    }
    
    
}
