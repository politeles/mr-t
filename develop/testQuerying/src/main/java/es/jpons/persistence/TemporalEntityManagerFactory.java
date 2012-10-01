/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jpons.persistence;

import java.util.Map;
import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;


/**
 *
 * @author aj2r
 */
public class TemporalEntityManagerFactory {

    private static TemporalEntityManagerFactory instance = null;
    private EntityManagerFactory managerFactory = null;
    private static Properties properties = null;

    protected TemporalEntityManagerFactory() {
        String persistenceName = "TemporalPU";
        managerFactory = Persistence.createEntityManagerFactory(persistenceName);//,
             //   properties);
    
    }

    public synchronized static TemporalEntityManagerFactory getInstance() {
        if (instance == null) {
            instance = new TemporalEntityManagerFactory();
        }
        return instance;
    }

    public static void setProperties(Properties properties) {
        if (instance != null) {
            throw new IllegalStateException("Instance already created.");
        }
        if (properties == null) {
            throw new IllegalArgumentException();
        }

        TemporalEntityManagerFactory.properties = properties;
    }

    public TemporalEntityManager createTemporalEntityManager() throws NamingException {
            return new TemporalEntityManager(managerFactory);
    }
    
    public boolean isOpen() {
        return managerFactory.isOpen();
    }

    public TemporalEntityManager createTemporalEntityManager(Map map0) throws
            NamingException {
        return new TemporalEntityManager(managerFactory, map0);
    }

    public void close() {
        managerFactory.close();
    }
}
