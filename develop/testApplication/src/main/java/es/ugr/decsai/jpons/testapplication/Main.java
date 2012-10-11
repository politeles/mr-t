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

import es.jpons.persistence.TemporalPersistenceManager;
import es.jpons.persistence.constants.OpenInterval;
import es.ugr.decsai.jpons.testapplication.persistence.Employee;
import es.jpons.temporal.types.PossibilisticTP;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 27/09/2012
 *
 */
public class Main {
    
    protected static void overlapsTM(PossibilisticVTP vTP,PossibilisticVTP comp){
        Double delta,delta1;
        Double distance,distance1;
        Double sqrt2 = Math.sqrt(2);
//        System.out.println("queried: " + vTP.get);
        //first of all: computing the 4 lines 
//        ls => y = 1*(x-ts);
//        le => y = -1*(x-te) = -x + te;
//        lo1 => y = -1*(x-ts) = -x + ts;
//        lo2 => y= 1*(x-te);
        
        // then the delta = lo2 - ls;
//        delta = vTP.getEndMP().getTime() + vTP.getStartMP().getTime();
        // delta2 = le-lo1;
        delta = delta1 = Math.abs(vTP.getEndMP().getTime()- vTP.getStartMP().getTime())/sqrt2;
        
        System.out.println("Delta:"+delta+ " delta1: "+delta1);
//        Double soly,soly1;
//        soly = (delta1 * sqrt2 + 2*vTP.getEndMP().getTime() + delta*sqrt2)/2;
//        soly1 = (-delta1 * sqrt2 + 2*vTP.getEndMP().getTime() + delta*sqrt2)/2;
//        Double solx,solx1;
//        solx = (delta1*sqrt2 - delta*sqrt2)/2;
//        solx1 = (delta1*sqrt2 +3*delta*sqrt2)/2;
//        
//        System.out.println("Sol y: "+soly + " sol y1: "+soly1);
//        System.out.println("Sol x: "+ solx +" sol x1: "+solx1);
//        //distance to lo2:
//        distance = Math.abs(comp.getIx()-comp.getIy()+vTP.getEndMP().getTime())/ sqrt2;
//        
//        //distance to le:
//        distance1 = Math.abs(-comp.getIx()-comp.getIy()+vTP.getEndMP().getTime())/ sqrt2;
        System.out.println("first x:" + vTP.getIx() + " y: " + vTP.getIy());
        System.out.println(" second x: " + comp.getIx() + " y: "+vTP.getIy());
        
        
        
        if(comp.getIx()<=vTP.getStartMP().getTime() && comp.getIy()<= (vTP.getStartMP().getTime()-vTP.getEndMP().getTime())){
            System.out.println("The point overlaps the vtp");
        }else{
            System.out.println("The point does not overlap the vtp");
        }
        
        
        
    }
    
    
    protected static PossibilisticVTP createVTP(Integer sday,Integer smonth,Integer syear,Integer eday,Integer emonth,Integer eyear){
        DateTime dateStartingMainPoint,dateStartingLeft,dateStartingRight;
            DateTime dateEndingMainPoint,dateEndingLeft,dateEndingRight;
            
            dateStartingMainPoint = new DateTime(syear,smonth, sday, 0, 0);
            
          
            dateStartingLeft = dateStartingMainPoint.minusDays(3);
            dateStartingRight = dateStartingMainPoint.plusDays(3);
            
            Duration d = new Duration(dateStartingLeft, dateStartingMainPoint);
            Duration d1 = new Duration(dateStartingMainPoint, dateStartingRight);
            
            
            
            
            dateEndingMainPoint = new DateTime(eyear,emonth, eday, 0, 0);
            dateEndingLeft = dateEndingMainPoint.minusDays(3);
            dateEndingRight = dateEndingMainPoint.plusDays(3);
            
            Duration d2 = new Duration(dateEndingLeft, dateEndingMainPoint);
            Duration d3 = new Duration(dateEndingMainPoint, dateEndingRight);
            
            
            PossibilisticTP start, end;
            PossibilisticVTP pvp;
            
//            start = new PossibilisticTP(
//                    dateStartingMainPoint.toDate(),
//                    dateStartingLeft.toDate(),
//                    dateStartingRight.toDate());
//            end = new PossibilisticTP(   
//                    dateEndingMainPoint.toDate(),
//                    dateEndingLeft.toDate(),
//                    dateEndingRight.toDate());
            
            pvp = new PossibilisticVTP(dateStartingMainPoint.toDate(),d.getMillis(),d1.getMillis(),dateEndingMainPoint.toDate(),d2.getMillis(),d3.getMillis());
            return pvp;
    }
    
    
    
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
//            annotatedClasses.add(TemporalPK.class);
//            annotatedClasses.add(PossibilisticTP.class);
//            annotatedClasses.add(PossibilisticVTP.class);
            
//            Session session = TemporalHibernateUtil.getSession(prop, annotatedClasses);
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

TemporalPersistenceManager manager = TemporalPersistenceManager.getInstance(prop, annotatedClasses);



//        try {
////            TemporalEntityManager manager = TemporalEntityManagerFactory.getInstance().createTemporalEntityManager();
//        } catch (NamingException ex) {
//            log.error(ex);
//        }
            
            DateTime dateStartingMainPoint,dateStartingLeft,dateStartingRight;
            DateTime dateEndingMainPoint,dateEndingLeft,dateEndingRight;
            
            dateStartingMainPoint = new DateTime(2012,3, 15, 0, 0);
            
          
            dateStartingLeft = new DateTime(2012,3, 1, 0, 0);
            dateStartingRight = new DateTime(2012,3, 21, 0, 0);
            
              Duration d = new Duration(dateStartingLeft, dateStartingMainPoint);
            Duration d1 = new Duration(dateStartingMainPoint, dateStartingRight);
            
            
            
            dateEndingMainPoint = new DateTime(2012,3, 30, 0, 0);
            dateEndingLeft = new DateTime(2012,3, 27, 0, 0);
            dateEndingRight = new DateTime(2012,4, 3, 0, 0);
            
            Duration d2 = new Duration(dateEndingLeft, dateEndingMainPoint);
            Duration d3 = new Duration(dateEndingMainPoint, dateEndingRight);
            
            
            PossibilisticTP start, end;
            PossibilisticVTP pvp;
            
            start = new PossibilisticTP(
                    dateStartingMainPoint.toDate(),
                    dateStartingLeft.toDate(),
                    dateStartingRight.toDate());
            end = new PossibilisticTP(   
                    dateEndingMainPoint.toDate(),
                    dateEndingLeft.toDate(),
                    dateEndingRight.toDate());
            
            pvp = new PossibilisticVTP(dateStartingMainPoint.toDate(),d.getMillis(),d1.getMillis(),dateEndingMainPoint.toDate(),d2.getMillis(),d3.getMillis());
            
            //new date to compare to
            DateTime dateStartingMainPoint1,dateStartingLeft1,dateStartingRight1;
            DateTime dateEndingMainPoint1,dateEndingLeft1,dateEndingRight1;
            
            dateStartingMainPoint1 = new DateTime(2011,3, 1, 0, 0);
            
          
            dateStartingLeft1 = new DateTime(2011,3, 1, 0, 0);
            dateStartingRight1 = new DateTime(2011,3, 21, 0, 0);
            
              Duration d4 = new Duration(dateStartingLeft1, dateStartingMainPoint1);
            Duration d5 = new Duration(dateStartingMainPoint1, dateStartingRight1);
            
            
            
            dateEndingMainPoint1 = new DateTime(2011,3, 27, 0, 0);
            dateEndingLeft1 = new DateTime(2011,3, 27, 0, 0);
            dateEndingRight1 = new DateTime(2011,4, 3, 0, 0);
            
            Duration d6 = new Duration(dateEndingLeft1, dateEndingMainPoint1);
            Duration d7 = new Duration(dateEndingMainPoint1, dateEndingRight1);
            
            
            PossibilisticTP start1, end1;
            PossibilisticVTP pvp1;
            
            start1 = new PossibilisticTP(
                    dateStartingMainPoint1.toDate(),
                    dateStartingLeft1.toDate(),
                    dateStartingRight1.toDate());
            end1 = new PossibilisticTP(   
                    dateEndingMainPoint1.toDate(),
                    dateEndingLeft1.toDate(),
                    dateEndingRight1.toDate());
            
            pvp1 = new PossibilisticVTP(dateStartingMainPoint1.toDate(),d4.getMillis(),d5.getMillis(),dateEndingMainPoint1.toDate(),d6.getMillis(),d7.getMillis());
            
            
            
            PossibilisticVTP pvp2,pvp3,pvp4;
            
            pvp2 = createVTP(10, 3, 2012, 21, 3, 2012);
            pvp3 = createVTP(1, 5, 2012, 27, 5, 2012);
            pvp4 = createVTP(30, 3, 2012, 25, 4, 2012);
            
            
//            overlapsTM(pvp1, pvp);
//            overlapsTM(pvp, pvp1);
//            
//            overlapsTM(pvp, pvp2);
//            overlapsTM(pvp, pvp3);
//            overlapsTM(pvp, pvp4);
//            System.out.println("These two do overlap");
//            overlapsTM(pvp2, pvp4);
            
            //ejemplo
            pvp4.setSide(OpenInterval.UC);
            pvp4.setEndLeft(null);
            pvp4.setEndMP(null);
            pvp4.setEndRight(null);
//            try{
//            manager.closeR(pvp4, pvp); // an error
//            }catch(Exception e){
//                log.error(e);
//            }
//            PossibilisticVTP closed = manager.closeR(pvp4, pvp3);
//            System.out.println(" Closed interval: " + closed);
//            
            
            Employee e1 = new Employee(new TemporalPK(23,1), "emp3");
            pvp.setSide(OpenInterval.UC);
            e1.setPvp(pvp);
            
            Employee e2 = new Employee(new TemporalPK(2,2), "emp4");
            e2.setPvp(pvp4);
            
            Employee e3 = new Employee(new TemporalPK(2, 3), "emp4");
            e3.setPvp(pvp3);

//            Employee e1 = new Employee(22, null, "emp2");
            //        try {
            //            Transaction t =.beginTransaction();
            Transaction beginTransaction = manager.beginTransaction();
//            beginTransaction.begin();
            
            manager.save(e1);
            manager.save(e2);
            manager.update(e3);
            
            String tableName = e3.getClass().getSimpleName();
            TemporalPersistenceManager.getSession().createQuery("Delete from "+ tableName + " where tid.id = :idval" ).setParameter("idval", e3.getTid().getId()).executeUpdate();
//            //query:
//            Session s = TemporalPersistenceManager.getSession();
//            Date startdate = new DateTime(2012, 3, 10, 0, 0).toDate();
//            Date enddate = new DateTime(2012,3,21,1,0,0).toDate();
//            List list = s.createQuery("from Employee e Where (:startdate < e.pvp.startMP ) and ((:enddate > e.pvp.startMP and :enddate < e.pvp.endMP ) or (:enddate > e.pvp.endMP)) ").
//                    setParameter("startdate", startdate).
//                    setParameter("enddate", enddate).
//                    list();
//            
//            if(list!=null){
//                for(int i=0;i<list.size();i++){
//                    Employee e = (Employee) list.get(i);
//                    System.out.println("Time: " + e.getPvp().getStartMP() + " , "+e.getPvp().getEndMP());
//                }
//            }
//            
            beginTransaction.commit();
            manager.close();
//            t.commit();
//       em.getTransaction().begin();
////        
//        em.persist(e1);
////        
//        em.getTransaction().commit();
//        
//            session.close();
        } catch (Throwable t) {
            log.error(t);
        }
        
        
        
    }
}
