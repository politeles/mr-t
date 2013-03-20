/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.jpons.uticalculator;

import java.util.List;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 * Utility functions to deal with utis
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public  class UtiUtil {
    
   public static TriangularDistribution getDistributionFromTime(Integer day,Integer month,Integer year){
      // double leftSide, core,rightSide;
       DateTime leftSide = null, core = null,rightSide = null;
       Chronology chrono = GJChronology.getInstance();
       if(year!=null){
           if(month==null && day==null){
               leftSide = new DateTime(year, 1, 1, 0, 0,0,chrono);
               core = new DateTime(year,6,1,0,0,0,chrono);
               rightSide = new DateTime(year,12,31,0,0,0,chrono);
                       
           }else if(month!=null && day ==null){
               leftSide = new DateTime(year, month, 1, 0, 0,0,chrono);
               int maximumValue = leftSide.dayOfMonth().getMaximumValue();
               core = new DateTime(year,month,15,0,0,0,chrono);
               rightSide = new DateTime(year,month,maximumValue,0,0,0,chrono);
               
           }else if(month!=null && day!=null){
               leftSide = new DateTime(year, month, day, 0, 0,0,chrono);
               core = new DateTime(year,month, day,12,0,0,chrono);
               rightSide = new DateTime(year,month, day,23,59,59,chrono);
               
           }
       }
       
       TriangularDistribution<Double> t = new TriangularDistribution(leftSide.getMillis(), core.getMillis(), rightSide.getMillis());
       return t;
   }
   
   public static Uti utiBuilder(Integer sday,Integer smonth,Integer syear,Integer eday,Integer emonth,Integer eyear ){
       TriangularDistribution<Double> start, end;
       
       start = getDistributionFromTime(sday,smonth, syear);
       end = getDistributionFromTime(eday,emonth, eyear);
       
       Uti result = new Uti(start.leftSide, start.core, start.rightSide, end.leftSide, end.core, end.rightSide);
       return result;
   }
   
   public static Uti obtainUtiFromTimeList(List<TriangularDistribution<Integer>> times){
       DateTime min,max;
//       
//       min = max = times.get(0);
//       
//       for(DateTime t:times){
//           if(t.isBefore(min)){
//               min = t;
//           }
//           if(t.isAfter(max)){
//               max = t;
//           }
//       }
       
       
       Uti result = null;
       return result;
   }
    
}
