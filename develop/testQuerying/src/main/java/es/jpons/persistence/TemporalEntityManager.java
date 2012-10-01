/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jpons.persistence;

import java.util.Map;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author aj2r
 */
public class TemporalEntityManager implements TemporalEntityManagerInterface {

    private final static Logger logger = LogManager.getLogger(
            TemporalEntityManager.class);
    private EntityManagerFactory factory = null;
//    private UserTransaction utx = null;
    private EntityManager manager = null;
    private Map map = null;

    public void setFlushMode(FlushModeType flushMode) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.setFlushMode(flushMode);
    }

    public void setTransactionTimeout(int timeout) throws SystemException {
//        utx.setTransactionTimeout(timeout);
    }

    public int getStatus() throws SystemException {
//        return utx.getStatus();
        return 0;
    }

    public void remove(Object entity) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.remove(entity);
    }

    public void refresh(Object entity) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.refresh(entity);
    }

    public void lock(Object entity, LockModeType lockMode) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.lock(entity, lockMode);
    }

    public <T> T getReference(Class<T> entityClass, Object primaryKey) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.getReference(entityClass, primaryKey);
    }

    public FlushModeType getFlushMode() {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.getFlushMode();
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.find(entityClass, primaryKey);
    }

    public Query createQuery(String qlString) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.createQuery(qlString);
    }

    public Query createNativeQuery(String sqlString, String resultSetMapping) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.createNativeQuery(sqlString, resultSetMapping);
    }

    public Query createNativeQuery(String sqlString, Class resultClass) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.createNativeQuery(sqlString, resultClass);
    }

    public Query createNativeQuery(String sqlString) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.createNativeQuery(sqlString);
    }

    public Query createNamedQuery(String name) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.createNamedQuery(name);
    }

    public boolean contains(Object entity) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.contains(entity);
    }

    public TemporalEntityManager(EntityManagerFactory factory) throws NamingException {
        this(factory, null);
    }

    public TemporalEntityManager(EntityManagerFactory factory, Map properties) throws
            NamingException {
        this.factory = factory;

//        utx =
//                (javax.transaction.UserTransaction) new javax.naming.InitialContext().
//                lookup("UserTransaction");

        this.map = properties;
    }

    public void begin() throws NotSupportedException, SystemException {
//        logger.info("Begin transaction: start [status=" + utx.getStatus() + "]");
        manager.getTransaction().begin();
//        utx.begin();
//        createEntityManager();
//        logger.info("Begin transaction: end [status=" + utx.getStatus() + "]");
//        manager.joinTransaction();
    }

    public void commit() throws RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SecurityException, IllegalStateException,
            SystemException {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.getTransaction().commit();
        //manager.flush();
//        logger.info("Commit: start [status=" + utx.getStatus() + "]");
//        utx.commit();
//        logger.info("Commit: end [status=" + utx.getStatus() + "]");
        manager.close();
        manager = null;
    }

    public void rollback() throws RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SecurityException, IllegalStateException,
            SystemException {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        //manager.clear();
//        logger.info("Rollback: start [status=" + utx.getStatus() + "]");
//        utx.rollback();
        manager.getTransaction().rollback();
//        logger.info("Rollback: end[status=" + utx.getStatus() + "]");
        manager.close();
        manager = null;
    }

    public <T> T merge(T entity) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        return manager.merge(entity);
    }

    public void persist(Object entity) {
        if (manager == null) {
            throw new IllegalStateException("There is no active transaction.");
        }
        manager.persist(entity);
    }



    @Override
    protected void finalize() throws Throwable {
        if (manager != null) {
            try {
                rollback();
            } finally {
                manager.close();
                manager = null;
//                utx = null;
            }
        }
        super.finalize();
    }

    private void createEntityManager() {
        if (manager == null) {
            if (map == null) {
                manager = factory.createEntityManager();
            } else {
                manager = factory.createEntityManager(map);
            }
        }
    }

    @Override
    public void clear() {
        manager.clear();
    }


}
