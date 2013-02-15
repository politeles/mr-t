/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.idbis.fuzzycalculator;

import es.ugr.decsai.idbis.fuzzy.FuzzyConstraintException;
import es.ugr.decsai.idbis.fuzzy.FuzzyNumber;

/**
 * A Trapezoidal fuzzy number that stores the four values and provides the evaluation function.
 * As it is natural, alpha <= beta <= delta <= gamma.
 * @author jose
 */
public class TrapezoidalFuzzyNumber extends FuzzyNumber{
    
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
    
     protected static Double getMin(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2){
         Double min;
         if(f1.getAlpha() < f2.getAlpha()){
            min = f1.getAlpha();
        }else{
            min = f2.getAlpha();
        }
         return min;
     }
     
     
     protected static Double getMax(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2){
         Double max;
         if(f1.getDelta() > f2.getDelta()){
            max = f1.getDelta();
        }else{
            max = f2.getDelta();
        }
         return max;
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
    
    
    public static Double DiscreteFeq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws  FuzzyConstraintException{
        Double result = 0D;
        if(f1.getDelta() <= f2.getAlpha() || f1.getAlpha() >= f2.getDelta()){
            result = 0D;
        }else if((f1.getGamma() + f1.getDelta()) >= (f2.getAlpha() + f2.getBeta() ) && (f1.getAlpha() + f1.getBeta()) <= (f2.getGamma() + f2.getDelta())){
            result = 1D;
        }else if((f1.getDelta() > f2.getAlpha()) && (f1.getGamma() + f1.getDelta()) < (f2.getAlpha() + f2.getBeta())){
            result = (f1.getDelta() - f2.getAlpha()) / (f2.getBeta() - f1.getGamma());
        }else{
            result = (f2.getDelta() - f1.getAlpha()) / (f1.getBeta() - f2.getGamma());
        }
        return result;
    }
    
    public static Double DiscreteNfeq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws  FuzzyConstraintException{
        Double result = 0D;
        if(((f2.getBeta() + f2.getAlpha() <= f1.getAlpha()) &&
                (f2.getAlpha() != (f1.getAlpha()+f1.getBeta()))) ||
                        ((f1.getDelta() <= (f2.getGamma() + f2.getDelta())) &&
                        (f2.getDelta() != (f1.getGamma() + f1.getDelta())))){
            result = 0D;
        }else if(f2.getAlpha() < (f1.getAlpha() + f1.getBeta())){
            if(f1.getGamma() + f1.getDelta() < f2.getDelta()){
                result = Math.min((f2.getBeta() + f2.getAlpha() - f1.getAlpha()) / (f2.getBeta() - f1.getBeta())
                        , (f2.getGamma() + f2.getDelta() - f1.getDelta()) / (f1.getGamma() + f2.getGamma()));
            }else{
                result = (f2.getBeta() + f2.getAlpha() - f1.getAlpha()) / (f2.getBeta() - f1.getBeta());
            }
            
        }else if((f1.getGamma() + f1.getDelta()) < f2.getDelta()){
            result = (f2.getGamma() + f2.getDelta() - f1.getDelta()) / (f1.getGamma() + f2.getGamma());
                    
        }else{
            result = 1D;
        }
        return result;
    }
    
    /**
     i* Iterative Implementation for the necessity operator.
     * The operator is implemented as: 
     * inf max (1- eval(f1),eval(f2))
     * @param f1 A trapezoidal fuzzy number.
     * @param f2 Another trapezoidal fuzzy number.
     * @param precision A value in the interval [0,1] with the precision in the iterative method.
     * @return The degree for the necessity equals operator.
     * @throws FuzzyConstraintException In case of error.
     */
    public static Double Neq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2,Double precision ) throws FuzzyConstraintException{
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
        
        Double val1, val2, maxval, inf;
        inf = Double.POSITIVE_INFINITY;
        for(Double index = min; index<max; index += precision){
            val1 = f1.evaluate(index);
            val2 = f2.evaluate(index);
            
            if(val1 > val2){
                maxval = val1;
            }else{
                maxval = val2;
            }
            
            if(maxval < inf){
                inf = maxval;
            }
            
        }
        
        return inf;
        
    }
    /**
     * Iterative implementation for the necessity equals operator.
     * @param f1 the first trapezoidal fuzzy number.
     * @param f2 the second trapezoidal fuzzy number.
     * @return a double in the unit interval [0,1]
     * @throws FuzzyConstraintException  In case of error.
     */
    public static Double Neq(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        return Neq(f1, f2, 0.01D);
    }
    
    
    public static Double Fgt(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2,Double precission) throws FuzzyConstraintException{
        Double result = 0D;
        
        Double min = getMin(f1, f2);
        Double max = getMax(f1, f2);
        Double val1, val2, maxval, inf;
        inf = Double.POSITIVE_INFINITY;
        for(double i = min; i< max;i+= precission){
            val1 = f1.evaluate(i);
            val2 = f2.evaluate(i);
            
            
        }
        
        return result;
    }
    
    
    /**
     * Discrete implementation for the Fuzzy Greater Than operator.
     * @param f1 the first trapezoidal number.
     * @param f2 the second trapezoidal number.
     * @return the membership degree for the fgt operator.
     * @throws FuzzyConstraintException in case of error.
     */
    public static Double Fgt(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.gamma > f2.delta){
            return 1D;
        }else if(f1.gamma < f2.delta && f1.delta >  f2.gamma){
            return (f1.delta - f2.gamma) / ((f2.delta - f2.gamma) - (f1.gamma - f1.delta));
        }else{
            return 0D;
        }
    }
    /**
     * Discrete implementation for the necessity greater than operator.
     * @param f1 the first trapezoidal number.
     * @param f2 the second trapezoidal number.
     * @return the membership degree for the fgt operator.
     * @throws FuzzyConstraintException in case of error.
     */
    public static Double Nfgt(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.alpha >= f2.delta ){
            return 1D;          
        }else if(f1.alpha < f2.delta && f1.beta > f2.gamma){
            return (f1.beta - f2.gamma) / ((f2.delta - f2.gamma) -(f1.alpha - f1.beta));
        }else 
            return 0D;
    }
    /**
     * Discrete implemetation for the fuzzy greater or equal operator.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Fgeq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.gamma >= f2.delta){
            return 1D;
        }else if(f1.gamma <  f2.beta &&  f1.delta > f2.alpha ){
            return (f1.delta - f2.alpha ) / ((f2.beta - f2.alpha) - (f1.gamma - f1.delta));
        }else{
            return 0D;
        }
    }
    /**
     * Implementation for the necessity fuzzy greater or equal.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static  Double Nfgeq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.alpha >= f2.beta){
            return 1D;
        }else if(f1.alpha < f2.beta && f1.beta > f2.alpha){
            return (f1.beta - f2.alpha ) / ((f2.beta - f2.alpha)- (f1.alpha - f1.beta));
        }else{
            return 0D;
        }
    }
    /**
     * Implementation for the fuzzy less than 
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Flt(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.beta <= f2.alpha){
            return 1D;
        }else if(f1.beta > f2.alpha && f1.alpha < f2.beta){
            return (f1.alpha - f2.beta) / ((f2.alpha - f2.beta) - (f1.beta - f1.alpha));
        }else{
            return 0D;
        }
    }
    /**
     * Necessity fuzzy less than
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Nflt(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.delta <= f2.alpha){
            return 1D;
        }else if(f1.delta > f2.alpha && f1.gamma < f2.beta){
            return (f1.gamma - f2.beta) / ((f2.alpha - f2.beta) -(f1.delta - f1.gamma));
        }else{
            return 0D;
        }
    }
    /**
     * Fuzzy less or equal to
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Fleq(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.beta <= f2.gamma){
            return 1D;
        }else if(f1.beta > f2.gamma && f1.alpha < f2.delta){
            return (f2.delta - f1.alpha) / ((f1.beta - f1.alpha) - (f2.gamma - f2.delta));
        }else {
            return 0D;
        }
    }
    /**
     * Necessity fuzzy less or equal to.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Nfleq(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2) throws FuzzyConstraintException{
        if(f1.delta <= f2.gamma){
            return 1D;
        } else if(f1.delta > f2.gamma && f1.gamma <f2.delta){
            return (f1.gamma -f2.delta) / ((f2.gamma -f2.delta) - (f1.delta -f1.gamma));
        }else{
            return 0D;
        }
    }
    /**
     * Much greater than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Mgt(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2, Double much) throws FuzzyConstraintException{
        if(f1.gamma > (f2.delta + much)){
            return 1D;
        }else if(f1.gamma < (f2.delta + much) && f1.delta > (f2.gamma + much)){
            return (f2.gamma + much - f1.delta) / ((f1.gamma - f1.delta) - (f2.delta - f2.gamma));
        }else{
            return 0D;
        }
        
    }
    /**
     * Necessity much greater than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Nmgt(TrapezoidalFuzzyNumber f1,TrapezoidalFuzzyNumber f2, Double much) throws FuzzyConstraintException{
        if(f1.alpha >=(f2.delta+ much)){
            return 1D;
        }else if(f1.alpha < (f2.delta + much) && f1.beta > (f2.gamma + much)){
            return (f2.gamma + much -f1.beta) / ((f1.alpha - f1.beta) - (f2.delta -f2.gamma));
        }else{
            return 0D;
        }
    }
    /**
     * Much less than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Mlt(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2, Double much) throws FuzzyConstraintException{
        if(f1.beta <= (f2.alpha - much)){
            return 1D;
        }else if(f1.beta > (f2.alpha -much) && f1.alpha < (f2.beta - much)){
            return (f2.beta - much - f1.alpha) / ((f1.beta - f1.alpha) - (f2.alpha - f2.beta));
        }else{
            return 0D;
        }
    }
    /**
     * Necessity much less than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public static Double Nmlt(TrapezoidalFuzzyNumber f1, TrapezoidalFuzzyNumber f2, Double much) throws FuzzyConstraintException{
        if(f1.delta <= (f2.alpha - much)){
            return 1D;
        }else if(f1.delta < (f2.alpha - much) && f1.gamma < (f2.beta - much)){
            return (f2.beta - much -f1.gamma) / ((f1.delta -f1.gamma)- (f2.alpha - f2.beta));
        }else{
            return 0D;
        }
    }

    public Double Feq(FuzzyNumber f1, FuzzyNumber f2, Double precision) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Feq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Neq(FuzzyNumber f1, FuzzyNumber f2, Double precision) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Neq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Fgt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nfgt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Fgeq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nfgeq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Flt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nflt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Fleq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nfleq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Mgt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nmgt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Mlt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double Nmlt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
