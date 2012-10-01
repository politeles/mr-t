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

package es.ugr.decsai.jpons.testapplication;

import es.ugr.decsai.jpons.testapplication.persistence.Employee;
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

    private static  AnnotationConfiguration config = new AnnotationConfiguration().setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").
                setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver").
                setProperty("hibernate.connection.url", "jdbc:mysql://localhost/temporaltest").
                setProperty("hibernate.connection.username", "root").
                setProperty("hibernate.connection.password", "toor").
                setProperty("hibernate.connection.pool_size", "1").
                setProperty("hibernate.connection.autocommit", "true").
                setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider").
                setProperty("hibernate.hbm2ddl.auto", "create").
                setProperty("hibernate.show_sql", "true").
                addAnnotatedClass(Employee.class)
  
                ;



//        HibernateUtil.setSessionFactory(config.buildSessionFactory());



    public static synchronized Session getSession() {
        if (factory == null) {
            factory =  config.buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void setSessionFactory(SessionFactory factory) {
        HibernateUtil.factory = factory;
    }
}
