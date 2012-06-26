/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.idbis.fuzzycalculator;

/**
 * A Trapezoidal fuzzy number that stores the four values and provides the evaluation function.
 * As it is natural, alpha <= beta <= delta <= gamma.
 * @author jose
 */
public class TrapezoidalFuzzyNumber {
    
    protected Double alpha;
    protected Double beta;
    protected Double gamma;
    protected Double delta;
    

    public TrapezoidalFuzzyNumber(Double alpha, Double beta, Double gamma,Double delta) {
        this.alpha = alpha;
        this.beta = beta;
        this.delta = delta;
        this.gamma = gamma;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public Double getGamma() {
        return gamma;
    }

    public void setGamma(Double gamma) {
        this.gamma = gamma;
    }
    
    protected void checkConstraints() throws FuzzyConstraintException{
        if(!(this.alpha <= this.beta ) &&
                (this.beta <= this.gamma) &&
                (this.gamma <= this.delta)){
            throw new FuzzyConstraintException("Values are not consistent");
        }
            
    }
    /**
     * Function to obtain the membership of a value d with respect to the trapezoid.
     * @param d
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double evaluate(Double d) throws FuzzyConstraintException{
        if(d==null ||
                this.alpha == null ||
                this.beta == null ||
                this.gamma == null ||
                this.delta == null
                ){
            throw new FuzzyConstraintException("values not initialized");
        }
        // cases d < alpha or d > delta
        Double value = 0D;
        //d belongs to the core
        if(d >= this.beta && d <= this.gamma){
            value = 1D;
        }else if(d >= this.alpha && d < this.beta){
            value = (d- this.alpha ) / (this.beta - this.alpha);
        }else if(d > this.gamma && d <=this.delta){
            value = (this.delta - d) / (this.delta - this.gamma);
       
        }
        
        
        
        return value;
        
        
    }
    /**
     * Fuzzy equality implemented as
     * sup min eval(f1),eval(f2))
     * @param f1
     * @param F2
     * @return 
     */
    public static Double Feq(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2, Double precision) throws FuzzyConstraintException{
        Double min;
        Double max;
        
        if(f1.getAlpha() < f2.getAlpha()){
            min = f1.getAlpha();
        }else{
            min = f2.getAlpha();
        }
        
        if(f1.getDelta() > f2.getDelta()){
            max = f1.getDelta();
        }else{
            max = f2.getDelta();
        }
        
        Double val1, val2, minval, sup;
        sup = 0D;
        for(Double index = min; index<max; index += precision){
            val1 = f1.evaluate(index);
            val2 = f2.evaluate(index);
            
            if(val1 < val2){
                minval = val1;
            }else{
                minval = val2;
            }
            
            if(minval > sup){
                sup = minval;
            }
            
        }
        
        
        
        
        
        
        
        return sup;
    }
    
    public static Double Feq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
       return Feq(f1, f2, 0.01);
    }
    
    
}
