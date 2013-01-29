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
import es.jpons.persistence.query.AllenRelation;
import es.jpons.persistence.query.QueryResult;
import es.jpons.persistence.query.TemporalQuery;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import es.ugr.decsai.jpons.testapplication.persistence.Employee;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 01/12/2012
 *
 */
public class ExecutionTime {

    private static Logger log = LogManager.getLogger(ExecutionTime.class);
    private static final int SAMPLES = 100000;
    private static final int AVG = 10;
//private static final boolean GENERATE_DB = true;
    private static final int ITERATIONS[] = {100, 150, 200, 250, 500,750,1000,1500,2000,2500,5000,5500,5500,10000};//, 12500,15000, 25000,50000,100000};
    private static final String FILENAME = "/home/jose/sources/phDThesis/gnuplot/resultsetsize.dat";

    public static void main(String[] args) {
        ExecutionTime pp = new ExecutionTime();
        try {
            Properties prop = new Properties();
            prop.load(pp.getClass().getResourceAsStream("hibernate.properties"));
            List<Class> annotatedClasses = new ArrayList<Class>();
            annotatedClasses.add(Employee.class);
            
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream,"UTF-8");
            BufferedWriter writer = new BufferedWriter(osw);
            
            

            TemporalPersistenceManager manager = TemporalPersistenceManager.getInstance(prop, annotatedClasses);
            // if(GENERATE_DB){
            List<Employee> empList = generateRandomEmployees(SAMPLES);

            int base = 0;
            int last = ITERATIONS[0];
//            
//            // main loop:
            for (int iter = 0; iter < ITERATIONS.length; iter++) {



                Transaction beginTransaction = manager.beginTransaction();
                
                

                for (int i = base; i < last; i++) {
                    manager.save(empList.get(i));
                }
                
                base = ITERATIONS[iter];
                if(ITERATIONS[iter]<SAMPLES){
                last = ITERATIONS[iter+1];
                }
                


                beginTransaction.commit();

              //     }

                PossibilisticVTP pvpQuery = new PossibilisticVTP(15, 10, 2009, 5, 5, 15, 10, 2010, 5, 5);

                TemporalQuery tq = manager.createTemporalQuery(new Employee());
                tq.setAllenRelation(AllenRelation.during, pvpQuery);
                // measure the time:
                double average = 0.0;
//                for (int j = 0; j < AVG; j++) {

                    long stime = System.currentTimeMillis();


                    List<QueryResult> list = tq.getList();


                    long etime = System.currentTimeMillis();
//
                    average += (etime - stime);
//                }

                System.out.println("Execution time: " + (average / AVG)+ " " +list.size());
                String text = new String(ITERATIONS[iter]+ " "+ (average / AVG)+ " " +list.size());
                    
                   
                    
                    
                    
                    
                    
//                String text = new String(ITERATIONS[iter]+ " "+ list.size());
                writer.write(text , 0, text.length());
                writer.newLine();
                
               

           }
            
            writer.close();
            osw.close();
            fileOutputStream.close();


        } catch (Throwable t) {
            log.error(t);
        }
    }

    public static PossibilisticVTP generateRandomPVP() {
        PossibilisticVTP pvp;

        Random r = new Random(1234);

        Integer sday = r.nextInt(27) + 1;
        Integer smonth = r.nextInt(11) + 1;
        Integer syear = r.nextInt(1000) + 1001;
        Integer ldays = r.nextInt(10) + 1;
        Integer rdays = r.nextInt(10) + 1;

        Integer eday = r.nextInt(27) + 1;
        Integer emonth = r.nextInt(11) + 1;
        Integer eyear = r.nextInt(1000) + syear;
        Integer eldays = r.nextInt(10) + 1;
        Integer erdays = r.nextInt(10) + 1;

        pvp = new PossibilisticVTP(sday, smonth, syear, ldays, rdays, eday, emonth, eyear, eldays, erdays);
        // System.out.println("generated pvp: "+ pvp);


        return pvp;
    }

    public static List<Employee> generateRandomEmployees(int samples) {
        List<Employee> employeeList = new ArrayList<Employee>(samples);
        for (int i = 0; i < samples; i++) {
            Employee emp = new Employee(new TemporalPK(i, 1), "random Name " + i);
            emp.setPvp(generateRandomPVP());
            employeeList.add(emp);
        }
        return employeeList;
    }
}
