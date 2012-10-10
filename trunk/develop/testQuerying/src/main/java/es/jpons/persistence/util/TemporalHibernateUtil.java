/*
 * Copyright (C) 2012 University of Granada, Department of Computer Science and Artificial Intelligence.
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

package es.jpons.persistence.util;


import es.jpons.persistence.interceptor.TemporalInterceptor;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 27/09/2012
 * 
 */
public class TemporalHibernateUtil {
    
private static TemporalHibernateUtil instance;    
private static  SessionFactory factory;
private static Properties prop;
private static String rn;
private static Logger log = Logger.getLogger(TemporalHibernateUtil.class.getName());

//    private static  AnnotationConfiguration config = new AnnotationConfiguration().setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").
//                setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver").
//                setProperty("hibernate.connection.url", "jdbc:mysql://localhost/temporaltest").
//                setProperty("hibernate.connection.username", "root").
//                setProperty("hibernate.connection.password", "toor").
//                setProperty("hibernate.connection.pool_size", "1").
//                setProperty("hibernate.connection.autocommit", "true").
//                setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider").
//                setProperty("hibernate.hbm2ddl.auto", "create").
//                setProperty("hibernate.show_sql", "true").
//                addAnnotatedClass(Employee.class)
//  
//                ;

    protected static void setProperties(String resourceName) {
       rn = resourceName;
        
    }

    
    protected TemporalHibernateUtil(){
        
        //load properties file:
        
        
//         prop = new Properties();
//        try {
//            prop.load(getClass().getResourceAsStream(rn));
//        } catch (IOException ex) {
//            log.error(ex);
//        }
    }


//        TemporalHibernateUtil.setSessionFactory(config.buildSessionFactory());



    public static synchronized Session getSession(Properties configuration,List<Class> annotatedClasses) {
        
//        if(instance==null){
//            log.trace("Creating instance from properties");
////          setProperties(configuration);
//          instance =  new TemporalHibernateUtil();
//        }
        
        Configuration cfg = new AnnotationConfiguration();//.setProperties(configuration);//Configuration();
        cfg.setProperties(configuration);
        cfg.addPackage(configuration.getProperty("package.persistence"));
        // esta funcion parece interesante
        //cfg.addSqlFunction(rn, null);
        log.trace("Registering temporal interceptor");
        cfg.setInterceptor(new TemporalInterceptor());
        
        for(Class c:annotatedClasses){
            cfg.addAnnotatedClass(c);
        }
        
        log.trace("Configuration from properties file");
        
        if (factory == null) {
            factory =  cfg.buildSessionFactory();
        }
        
        log.trace("Session factory created");
        return factory.openSession();
    }

    public static void setSessionFactory(SessionFactory factory) {
        TemporalHibernateUtil.factory = factory;
    }
}
