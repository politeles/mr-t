package es.ugr.decsai.jpons.uticalculator;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length < 6){
            System.err.println("Sintax error: Incorrect parameter number");
            System.err.println("parameters: start1 start start2 end1 end end2");
            System.exit(-1);
        }
        int precision = 25;
        if(args.length == 7){
            precision = Integer.valueOf(args[6]);
        }
        
        
        double start1,start,start2,end1,end,end2;
        
        start1 = Double.valueOf(args[0]);
        start = Double.valueOf(args[1]);
        start2 = Double.valueOf(args[2]);
        
        end1 = Double.valueOf(args[3]);
        end = Double.valueOf(args[4]);
        end2 = Double.valueOf(args[5]);
        
     //   System.out.println("Values: "+ start1 + ", " + start + " start2");
        
        Uti u = new Uti(start1, start, start2, end1, end, end2);
        u.setIterations(precision);
        List<IntervalPoint> intervalPoints = u.getIntervalPoints();
        
        for(IntervalPoint p:intervalPoints){
            System.out.println(p.tx+ "\t"+ p.ty + "\t"+ p.membership);
        }
        
    }
}
