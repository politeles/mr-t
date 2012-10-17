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
import es.jpons.persistence.exception.TemporalException;
import es.jpons.persistence.exception.TemporalInsertException;
import es.jpons.persistence.query.AllenRelation;
import es.jpons.persistence.query.TemporalQuery;
import es.jpons.persistence.util.TemporalHibernateUtil;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
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
import org.joda.time.Duration;

/**
 * Temporal Persistence Manager. This class implements all the persistence
 * operations for a temporal database.
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 04/10/2012
 *
 */
public class TemporalPersistenceManager {

    protected static Session session;
    protected static TemporalPersistenceManager manager = null;
    protected static Logger log = LogManager.getLogger(TemporalPersistenceManager.class.getName());

    public static Session getSession() {
        return session;
    }

    protected TemporalPersistenceManager() {
    }

    /**
     * Static function to get an instance.
     *
     * @param prop A properties file with the hibernate configuration.
     * @param annotatedClasses A list with the annotated persistence classes.
     * @return An instance of the persistence manager.
     */
    public static TemporalPersistenceManager getInstance(Properties prop, List<Class> annotatedClasses) {
        if (manager == null) {
            session = TemporalHibernateUtil.getSession(prop, annotatedClasses);
            manager = new TemporalPersistenceManager();
        }
        return manager;
    }

    /**
     * Determines if the given entity is a valid-time object or not.
     *
     * @param entity The entity to persist.
     * @return True if the entity is a valid-time object, false otherwise.
     */
    protected PossibilisticVTP getValidTime(Object entity) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = entity.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        PossibilisticVTP validTime = null;
        boolean found = false;
        for (int i = 0; i < declaredFields.length && !found; i++) {
            if (declaredFields[i].getType().equals(PossibilisticVTP.class)) {
                found = true;
//                validTime = (PossibilisticVTP) declaredFields[i].get(entity);
                String fieldName = declaredFields[i].getName();
                fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                Class [] noparams = {};
                Object invoke = entity.getClass().getMethod(fieldName, new Class[]{}).invoke(entity, null);
                validTime = (PossibilisticVTP) invoke;
            }
        }
        return validTime;
    }

    /**
     * Update the valid time value for a given entity
     *
     * @param entity The entity
     * @param vt The new valid time value.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    protected void updateValidTime(Object entity, PossibilisticVTP vt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> c = entity.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        PossibilisticVTP validTime = null;
        boolean found = false;
        for (int i = 0; i < declaredFields.length && !found; i++) {
            if (declaredFields[i].getType().equals(PossibilisticVTP.class)) {
                found = true;
//                validTime = (PossibilisticVTP) declaredFields[i].get(entity);
                String fieldName = declaredFields[i].getName();
                fieldName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                Class [] noparams = {};
                Object invoke = entity.getClass().getMethod(fieldName, new Class[]{PossibilisticVTP.class}).invoke(entity, vt);
                validTime = (PossibilisticVTP) invoke;
            }
        }
    }

    /**
     * Obtains the primary key of a given temporal object
     *
     * @param temporalEntity The entity
     * @return The primary key.
     * @throws TemporalException
     */
    public TemporalPK getPK(Object temporalEntity) throws TemporalException {
        if (temporalEntity == null) {
            return null;
        } else {
            TemporalPK key;
            try {
                key = (TemporalPK) temporalEntity.getClass().getMethod("getTid", new Class[]{}).invoke(temporalEntity, null);
                return key;
            } catch (Exception ex) {
                log.error(" Error obtaining the pk of a temporal object");
                throw new TemporalException(ex);
            }

        }
    }

    /**
     * Persist the given transient temporal instance, assigning a generated
     * identifier. If the object is a valid-time object, then the persistence
     * algorithm is the following: <ul> <li>If the item does overlap with any
     * existing items, then reject the insertion. </li> <li>If the item does not
     * overlap any existing items, then insert.</li> <li>If exist any open
     * tuple, then call modify.</li> </ul>
     *
     *
     *
     * @param entity the object to persist.
     * @return The generated identifier.
     * @throws HibernateException In case of error.
     * @throws TemporalInsertException In case of error when inserting: The
     * interval does overlaps or during any other existing valid time object.
     *
     */
    public Serializable save(Object entity) throws HibernateException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, TemporalInsertException, TemporalException {
        //retrieve whether the object is a valid-time entity or not:
        Serializable generatedId = null;
        PossibilisticVTP validTime = getValidTime(entity);
        if (validTime != null) {
            TemporalPK key = getPK(entity);
            // first of all, check if exists an open version:
            Criteria cmodify = session.createCriteria(entity.getClass());
            cmodify = criteriaModify(cmodify, key);
            List updateList = cmodify.list();
            if (updateList.size() > 0) {
                //close the current version
                Object oldEntity = updateList.get(0);
                updateEntity(entity, oldEntity, validTime);
            }else{
                // if no open tuples, then check if the insertion is possible.
            Criteria criteria = session.createCriteria(entity.getClass());
            criteria = criteriaInsert(criteria, validTime, key);
            List list = criteria.list();
            if (list.size() > 0) {
                // the list has some elements, and the insertion is rejected.

                log.debug("Insertion rejected");
                throw new TemporalInsertException("Insertion Rejected: The valid time overlaps or during any other valid time");


            } else {
                log.debug("Insertion done");
                generatedId = session.save(entity);
            }
            }
            //            criteria.add(Restrictions.)
            //session.
        } else {
            generatedId = session.save(entity);
        }
        return generatedId;


    }

    /**
     * Function that stablishes the constrains for the temporal insertion.
     *
     * @param c An initialized criteria object.
     * @param validTime The valid time to intert
     * @return A criteria to query the database.
     */
    protected Criteria criteriaInsert(Criteria c, PossibilisticVTP validTime, TemporalPK key) {


        if (c == null) {
            return null;
        }
        c = c.add(
                Restrictions.and(
                Restrictions.gt("pvp.startMP", validTime.getStartMP()),
                Restrictions.or(
                Restrictions.and(Restrictions.lt("pvp.startMP", validTime.getEndMP()), Restrictions.gt("pvp.endMP", validTime.getEndMP())),
                Restrictions.lt("pvp.endMP", validTime.getEndMP())),
                Restrictions.eq("tid.id", key.getId())));

        return c;
    }

    /**
     * Function for release the connection.
     *
     * @return
     */
    public Connection close() {
        return TemporalPersistenceManager.session.close();
    }

    /**
     * Starts a new transaction
     *
     * @return
     */
    public Transaction beginTransaction() {
        return session.beginTransaction();
    }

    /**
     * Function to close a vtp from another
     *
     * @param toClose The vtp to close
     * @param newVtp The other vtp to start
     * @return A copy of the object toClose closed to the left.
     * @throws TemporalException If the closure of the vtp can not be computed.
     */
    public PossibilisticVTP closeR(PossibilisticVTP toClose, PossibilisticVTP newVtp) throws TemporalException {
        if (toClose.getSide()!=null&&toClose.getSide().compareTo(OpenInterval.UC) == 0) {
            DateTime startmp = new DateTime(toClose.getStartMP());
//            DateTime leftmp = startmp.minus(toClose.getStartLeft());
            DateTime rightmp = startmp.plus(toClose.getStartRight());

            DateTime newmp = new DateTime(newVtp.getStartMP());
            DateTime newleft = newmp.minus(newVtp.getStartLeft());
//            DateTime newright = newmp.plus(newVtp.getStartRight());

            if (rightmp.isBefore(newleft)) {
                log.trace("Closing ending point");
                Duration d = new Duration(startmp, newmp);
                Duration d1 = new Duration(d.getMillis() / 2);


                DateTime closeMp = new DateTime(startmp);
                closeMp = closeMp.plus(d1);

                Duration left = new Duration(startmp, closeMp);
                Duration right = new Duration(closeMp, newleft);

                toClose.setEndMP(closeMp.getMillis());
                toClose.setEndLeft(left.getMillis());
                toClose.setEndRight(right.getMillis());

                toClose.setSide(null);



            } else {
                log.error("The point cannot be closed");
                throw new TemporalException("The point cannot be closed");
            }


//            
//            DateTime lefts = startmp.plus( new Instant(newVtp.getStartLeft()));
//            if(newVtp.getStartMP()> )
        } else {
            log.error("The point is not open");
            throw new TemporalException("The point is not open");
        }


        return toClose;
    }

    /**
     * Update the given entity. If the entity is a temporal entity, then, the
     * last version of the same entity is closed and updated by this one.
     *
     * @param entity The entity to update
     * @throws HibernateException In case of any Hibernate error.
     * @throws TemporalException In case of an error in the temporal
     * calculations.
     */
    public void update(Object entity) throws HibernateException, TemporalException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        PossibilisticVTP validTime = getValidTime(entity);
        if (validTime != null) {
            TemporalPK key = getPK(entity);
            // first: retrieve the more recent object with the same pk:
            Criteria c = session.createCriteria(entity.getClass());
            c = criteriaModify(c, key);
            List list = c.list();
            if (list.size() == 1) {
                Object oldEntity = list.get(0);
               updateEntity(entity, oldEntity, validTime);


            } else {
                log.debug("There are temporal inconsistencies in the database");
            }


        } else {
            log.debug("updating non-temporal entity");
            session.update(entity);
        }
    }

    /**
     * Core for the update entity
     * @param newEntity The new entity to update.
     * @param oldEntity The old entity.
     * @param newValidTime The new value for the valid-time.
     * @throws TemporalException In case of error
     */
    protected void updateEntity(Object newEntity, Object oldEntity, PossibilisticVTP newValidTime) throws TemporalException {
        try{
        PossibilisticVTP toClose = getValidTime(oldEntity);
        //in case of error, the closeR function aborts the update:
        PossibilisticVTP closed = closeR(toClose, newValidTime);

        updateValidTime(oldEntity, closed);
        //update the old entity:
        session.update(oldEntity);
        // save the new entity:
        session.save(newEntity);
        }catch(Exception e){
            log.error(e);
            throw new TemporalException(e);
        }
    }

    /**
     * Criteria for the insert operation
     *
     * @param criteria An initialized criteria
     * @param key the temporal primary key of the object
     * @return The criteria to modify a tuple.
     */
    protected Criteria criteriaModify(Criteria criteria, TemporalPK key) {
        return criteria.add(Restrictions.and(Restrictions.eq("tid.id", key.getId()),
                Restrictions.eq("pvp.side", OpenInterval.UC)));
    }

    /**
     * Removes a persistent instance from the datastore
     *
     * @param entity The instance. If entity is a temporal instance, then, all
     * the versions are deleted.
     * @throws HibernateException In case of Hibernate Error
     * @throws TemporalException In case of temporal error.
     */
    public void delete(Object entity) throws HibernateException, TemporalException {
        try {
            PossibilisticVTP validTime = getValidTime(entity);
            if (validTime != null) {
                TemporalPK key = getPK(entity);
                String tableName = entity.getClass().getSimpleName();
                session.createQuery(
                        "Delete from " + tableName
                        + " where tid.id = :idval")
                        .setParameter("idval", key.getId()).
                        executeUpdate();


            } else {
                log.debug("delete of non-temporal object");
                session.delete(entity);
            }

        } catch (Exception e) {
            throw new TemporalException(e);
        }

    }
    
    
    public TemporalQuery createTemporalQuery(Object entity){
        return new TemporalQuery(session,entity);
    }
}
