/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.jpons.persistence;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author dpp
 */
public interface TemporalEntityManagerInterface {

    void begin() throws NotSupportedException, SystemException;

    void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException;

    boolean contains(Object entity);

    Query createNamedQuery(String name);

    Query createNativeQuery(String sqlString, String resultSetMapping);

    Query createNativeQuery(String sqlString, Class resultClass);

    Query createNativeQuery(String sqlString);

    Query createQuery(String qlString);

    <T> T find(Class<T> entityClass, Object primaryKey);

    FlushModeType getFlushMode();

    <T> T getReference(Class<T> entityClass, Object primaryKey);

    int getStatus() throws SystemException;

    void lock(Object entity, LockModeType lockMode);

    <T> T merge(T entity);

    void persist(Object entity);

    void refresh(Object entity);

    void remove(Object entity);

    void rollback() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException;

    void setFlushMode(FlushModeType flushMode);

    void setTransactionTimeout(int timeout) throws SystemException;

    void clear();

}
