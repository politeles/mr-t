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
import es.jpons.persistence.query.AllenRelation;
import es.jpons.persistence.query.QueryResult;
import es.jpons.persistence.query.TemporalQuery;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import es.ugr.decsai.jpons.testapplication.persistence.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 01/12/2012
 * 
 */
public class ExampleClass {
    private static Logger log = LogManager.getLogger(ExampleClass.class);
    
    
    public static void main(String[] args){
        ExampleClass pp = new ExampleClass();
        
         try {
            Properties prop = new Properties();
            prop.load(pp.getClass().getResourceAsStream("hibernate.properties"));
            List<Class> annotatedClasses = new ArrayList<Class>();
            annotatedClasses.add(Employee.class);

            TemporalPersistenceManager manager = TemporalPersistenceManager.getInstance(prop, annotatedClasses);
            
            // Create the instances
            
            PossibilisticVTP pvp1,pvp2,pvp3,pvp4,pvp5,pvp6,pvp7,pvp8;
            
            pvp1 = new PossibilisticVTP(18, 10, 2009, 8, 8, 18, 10, 2010, 8, 8);
            pvp2 = new PossibilisticVTP(19, 10, 2010, 8, 8, OpenInterval.UC);
            pvp3 = new PossibilisticVTP(20, 5, 2007, 5, 5, 20, 1, 2008, 3, 10);
            pvp4 = new PossibilisticVTP(21, 1, 2008, 3, 10, 25, 5, 2009, 1, 5);
            pvp5 = new PossibilisticVTP(26, 5, 2009, 1, 5, 25, 10, 2010, 2, 9);
            pvp6 = new PossibilisticVTP(15, 5, 2007, 12,2,OpenInterval.UC);
            pvp7 = new PossibilisticVTP(26, 7, 2009, 1, 5, 16, 10, 2019, 2, 9);
            pvp8 = new PossibilisticVTP(27, 9, 2010, 2, 3, 27, 2, 2011, 2, 3);
            
            Employee e1,e2,e3,e4,e5,e6,e7,e8;
            
            e1 = new Employee(new TemporalPK(1, 1), "Josh");
            e1.setPvp(pvp1);
       
             e2 = new Employee(new TemporalPK(1, 2), "Josh");
             e2.setPvp(pvp2);

             e3 = new Employee(new TemporalPK(2, 1), "Robert");
             e3.setPvp(pvp3);

             e4 = new Employee(new TemporalPK(2, 2), "Robert");
             e4.setPvp(pvp4);

             e5 = new Employee(new TemporalPK(2, 3), "Robert");
             e5.setPvp(pvp5);

             e6 = new Employee(new TemporalPK(3, 1), "Alex");
             e6.setPvp(pvp6);

             e7 = new Employee(new TemporalPK(4, 1), "Tyna");
             e7.setPvp(pvp7);

             e8 = new Employee(new TemporalPK(5, 1), "Rose");
             e8.setPvp(pvp8);
            
            
            
         Transaction beginTransaction = manager.beginTransaction();
         
         manager.save(e1);
        // manager.save(e2);
         manager.save(e3);
         manager.save(e4);
         manager.save(e5);
         //manager.save(e6);
         manager.save(e7);
         manager.save(e8);
         
         beginTransaction.commit();
         
         PossibilisticVTP pvpQuery = new PossibilisticVTP(15, 10,2009,5,5, 15,10,2010,5,5);
         
          TemporalQuery tq = manager.createTemporalQuery(e3);
            tq.setAllenRelation(AllenRelation.during, pvpQuery);
            List<QueryResult> list = tq.getList();
         
            for(QueryResult qr:list){
                System.out.println("aggregation: "+qr.getAggregation()
                        + " temporal "+qr.getTemporalSatisfaction()+
                        " endmp: " + qr.getVtp().getEndMP() + " vid: " + qr.getKey());
            }
            
            
             manager.close();
        
         }catch(Throwable t){
             log.error(t);
         }
        
    }
    
    

}
