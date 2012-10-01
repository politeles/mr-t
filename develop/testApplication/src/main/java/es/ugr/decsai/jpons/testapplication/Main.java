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
import es.jpons.persistence.util.TemporalHibernateUtil;
import es.jpons.temporal.types.TemporalPK;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 27/09/2012
 *
 */
public class Main {

    private static Logger log = LogManager.getLogger(Main.class.getName());

//    public TemporalWebEntityManager configure() {
//        TemporalWebEntityManager entityManager = null;
//        try {
//            Properties prop = new Properties();
//            try {
//                prop.load(getClass().getResourceAsStream("persistence.properties"));
//            } catch (Exception ex) {
//                log.error(ex);
//            }
//
//            entityManager = new TemporalWebEntityManager(prop);
//
//        } catch (NamingException ex) {
//            log.error(ex);
//        } finally {
//            return entityManager;
//        }
//
//
//    }
    public static void main(String[] args) {
        Main pp = new Main();
        log.trace("Initializing hibernate session");
        
        try {
            Properties prop = new Properties();
            prop.load(pp.getClass().getResourceAsStream("hibernate.properties"));
            List<Class> annotatedClasses = new ArrayList<Class>();
            annotatedClasses.add(Employee.class);
            
            Session session = TemporalHibernateUtil.getSession(prop,annotatedClasses);
//        }catch(Exception ex){
//            log.error(ex);
//        }
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TemporalPU");
//            EntityManager em = emf.createEntityManager();
// 
//            
//           TemporalWebEntityManager manager = pp.configure();
//            TemporalEntityManagerInterface entityManager = TemporalWebEntityManager.getEntityManager();
//            




//        try {
////            TemporalEntityManager manager = TemporalEntityManagerFactory.getInstance().createTemporalEntityManager();
//        } catch (NamingException ex) {
//            log.error(ex);
//        }

Employee e1 = new Employee(new TemporalPK(23),"emp3");

//            Employee e1 = new Employee(22, null, "emp2");


//        try {
            Transaction t = session.beginTransaction();

            session.save(e1);
            t.commit();
//       em.getTransaction().begin();
////        
//        em.persist(e1);
////        
//        em.getTransaction().commit();
//        
            session.close();
        } catch (Throwable t) {
            log.error(t);
        }



    }
}
