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

package es.ugr.decsai.historydb;


import es.ugr.decsai.historydb.model.Contents;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 27/09/2012
 * 
 */
public class HibernateUtil {
private static  SessionFactory factory;
private static final String PROPERTIES_FILENAME = "configuration.properties";
//private static final String DIALECT="hibernate.dialect";
//private static final String DRIVER="hibernate.connection.driver_class";
//private static final String URL="hibernate.connection.url";
//private static final String USER="hibernate.connection.username";
//private static final String PWD="hibernate.connection.password";
//private static final String POOL="hibernate.connection.pool_size";
//private static final String AUTOCOMMIT="hibernate.connection.autocommit";
//private static final String HBMDDL="hibernate.hbm2ddl.auto";
//private static final String SHOWSQL="hibernate.show_sql";

    private static  AnnotationConfiguration config; 
//= new AnnotationConfiguration().setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect").
//                setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver").
//                setProperty("hibernate.connection.url", "jdbc:hsqldb:file:E:\\Users\\Jose\\Documents\\sources\\mr-t\\develop\\excel2sql\\documents\\history").
//                setProperty("hibernate.connection.username", "sa").
//                setProperty("hibernate.connection.password", "").
//                setProperty("hibernate.connection.pool_size", "2").
//                setProperty("hibernate.connection.autocommit", "true").
////                setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider").
//                setProperty("hibernate.hbm2ddl.auto", "create").
//                setProperty("hibernate.show_sql", "true").
//                addAnnotatedClass(Test.class)
//  
//                ;



//        HibernateUtil.setSessionFactory(config.buildSessionFactory());



    public static synchronized Session getSession() {
        if (factory == null) {
            Properties p = new Properties();
            try{
            p.load(ClassLoader.getSystemResourceAsStream(PROPERTIES_FILENAME));
//            String dialect = p.getProperty(DIALECT);
//            String driver = p.getProperty(DRIVER);
//            String url = p.getProperty(URL);
//            String user = p.getProperty(USER);
//            String pass = p.getProperty(PWD);
//            String pool = p.getProperty(POOL);
//            String autocommit = p.getProperty(AUTOCOMMIT);
//            String auto = p.getProperty(HBMDDL);
//            String show = p.getProperty(SHOWSQL);
            
            config = new AnnotationConfiguration()
                    .setProperties(p)
                    .addAnnotatedClass(Contents.class);
                    
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
            factory =  config.buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void setSessionFactory(SessionFactory factory) {
        HibernateUtil.factory = factory;
    }
}
