package es.jpons.persistence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Properties;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;


/**
 *
 * @author jp
 */
public class TemporalWebEntityManager {

    private static TemporalEntityManagerInterface manager;
//    private Logger logger = LoggerFactory.getLogger(getClass());
    private static Properties properties;
    private static boolean test = false;
    private static Logger log = LogManager.getLogger(TemporalWebEntityManager.class.getName());

    public TemporalWebEntityManager(Properties persistenceProperties) throws NamingException {
        //TODO IMPROVE THIS RANCID METHOD -> A CONSTRUCTOR TO INITIALIZE A CLASS???
        properties = persistenceProperties;
        properties.list(System.out);
        if (manager == null) {
            TemporalEntityManagerFactory.setProperties(persistenceProperties);
            manager =
                    TemporalEntityManagerFactory.getInstance().createTemporalEntityManager();
        }
    }

    public static TemporalEntityManagerInterface getEntityManager() {
        if (manager == null && !test) {

            try {
                TemporalEntityManagerFactory.setProperties(properties);
                manager = TemporalEntityManagerFactory.getInstance().createTemporalEntityManager();
            } catch (NamingException ex) {
                log.error(ex);
            }
        }
        return manager;
    }
}
