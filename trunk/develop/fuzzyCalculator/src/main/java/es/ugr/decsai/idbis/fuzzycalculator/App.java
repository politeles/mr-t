package es.ugr.decsai.idbis.fuzzycalculator;

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
        TrapezoidalFuzzyNumber t = new TrapezoidalFuzzyNumber(0D, 10D, 15D, 20D);
        TrapezoidalFuzzyNumber t1 = new TrapezoidalFuzzyNumber(15D, 20D, 25D, 30D);
        
        
        for(double i=0;i< 30;i++){
            try {
                System.out.println("i: "+i + " eval "+t.evaluate(i)); 
            } catch (FuzzyConstraintException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            System.out.println("FEQ = "+TrapezoidalFuzzyNumber.Feq(t, t1)); 
        } catch (FuzzyConstraintException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
