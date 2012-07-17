package es.ugr.decsai.idbis.fuzzycalculator;

import es.ugr.decsai.idbis.fuzzy.FuzzyConstraintException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TrapezoidalFuzzyNumber query = new TrapezoidalFuzzyNumber(0D,0D, 16D, 18D);
        
        TrapezoidalFuzzyNumber t = new TrapezoidalFuzzyNumber(16D, 18D, 20D, 22D);
        TrapezoidalFuzzyNumber t1 = new TrapezoidalFuzzyNumber(10D, 15D, 20D, 25D);
        TrapezoidalFuzzyNumber t2 = new TrapezoidalFuzzyNumber(17D, 20D, 25D, 30D);
        TrapezoidalFuzzyNumber t3 = new TrapezoidalFuzzyNumber(20D, 30D, 30D, 35D);
        
        
//        for(double i=0;i< 30;i++){
//            try {
//                System.out.println("i: "+i + " eval "+t.evaluate(i)); 
//            } catch (FuzzyConstraintException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        try {
            
            ArrayList<Double> feq,nfeq,fgt,nfgt,fgeq,nfgeq,flt,nflt,fleq,nfleq,mgt,nmgt,mlt,nmlt;
            ArrayList<TrapezoidalFuzzyNumber> numbers;
            
            feq = new ArrayList<Double>();
            nfeq = new ArrayList<Double>();
            fgt = new ArrayList<Double>();
            nfgt = new ArrayList<Double>();
            fgeq = new ArrayList<Double>();
            nfgeq = new ArrayList<Double>();
            flt = new ArrayList<Double>();
            nflt = new ArrayList<Double>();
            fleq = new ArrayList<Double>();
            nfleq = new ArrayList<Double>();
            mgt = new ArrayList<Double>();
            mlt = new ArrayList<Double>();
            nmlt = new ArrayList<Double>();
            
            numbers = new ArrayList<TrapezoidalFuzzyNumber>();
            
            numbers.add(t);
            numbers.add(t1);
            numbers.add(t2);
            numbers.add(t3);
            
            Double much = 30D;
            
            System.out.println(" FEQ  | D-FEQ |  NEQ  | D-NEQ | FGT | NFGT  | FGEQ  | NFGEQ  | FLT  | NFLT  | FLEQ  | NFLEQ  | MGT  | NMGT  | MLT  | NMLT ");
            
            for(int i = 0; i< numbers.size(); i++){
                System.out.println(
                        String.format("|%1$20s|", TrapezoidalFuzzyNumber.Feq(numbers.get(i), query))+
                        String.format("|%1$20s|", TrapezoidalFuzzyNumber.DiscreteFeq(numbers.get(i), query))+
                         
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Neq(numbers.get(i), query)) + 
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.DiscreteNfeq(numbers.get(i), query)) + 
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Fgt(numbers.get(i), query)) + 
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nfgt(numbers.get(i), query)) + 
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Fgeq(numbers.get(i), query)) + 
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nfgeq(numbers.get(i), query)) + 
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Flt(numbers.get(i), query)) + 
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nflt(numbers.get(i), query)) + " | " +
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Fleq(numbers.get(i), query)) + " | " +
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nfleq(numbers.get(i), query)) + " | " +
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Mgt(numbers.get(i), query,much)) + " | " +
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nmgt(numbers.get(i), query,much)) + " | " +
                        
                        
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Mlt(numbers.get(i), query,much)) + " | " +
                        String.format("|%1$20s|",TrapezoidalFuzzyNumber.Nmlt(numbers.get(i), query,much)) + " | " 
                        
                        
                        
                        
                        
                        
                        
                        );
            }
            
            
            
//            System.out.println("FEQ = "+TrapezoidalFuzzyNumber.Feq(t, query) + " NEQ " + TrapezoidalFuzzyNumber.Neq(t, query)); 
//            System.out.println("FEQ = "+TrapezoidalFuzzyNumber.Feq(t1, query)+ " NEQ " + TrapezoidalFuzzyNumber.Neq(t1, query)); 
//            System.out.println("FEQ = "+TrapezoidalFuzzyNumber.Feq(t2, query)+ " NEQ " + TrapezoidalFuzzyNumber.Neq(t2, query)); 
//            System.out.println("FEQ = "+TrapezoidalFuzzyNumber.Feq(t3, query)+ " NEQ " + TrapezoidalFuzzyNumber.Neq(t3, query)); 
        } catch (FuzzyConstraintException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
