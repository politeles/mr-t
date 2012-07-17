/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.idbis.fuzzy;



/**
 * Interface ofr the implementation of all the fuzzy operators.
 * @author jose
 */
public interface FuzzyOperators {

    /**
     * Fuzzy equality implemented as
     * sup min eval(f1),eval(f2))import es.ugr.decsai.idbis.fuzzycalculator.FuzzyNumber;
     * @param f1
     * @param f2
     * @param precision
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Feq(FuzzyNumber f1, FuzzyNumber f2, Double precision) throws FuzzyConstraintException;

    /**
     * Implementation for the fuzzy equality operator.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Feq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
    i* Iterative Implementation for the necessity operator.
     * The operator is implemented as: 
     * inf max (1- eval(f1),eval(f2))
     * @param f1 A FuzzyNumber fuzzy number.
     * @param f2 Another FuzzyNumber fuzzy number.
     * @param precision A value in the interval [0,1] with the precision in the iterative method.
     * @return The degree for the necessity equals operator.
     * @throws FuzzyConstraintException In case of error.
     */
    public Double Neq(FuzzyNumber f1, FuzzyNumber f2, Double precision) throws FuzzyConstraintException;

    /**
     * Iterative implementation for the necessity equals operator.
     * @param f1 the first FuzzyNumber fuzzy number.
     * @param f2 the second FuzzyNumber fuzzy number.
     * @return a double in the unit interval [0,1]
     * @throws FuzzyConstraintException  In case of error.
     */
    public Double Neq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Discrete implementation for the Fuzzy Greater Than operator.
     * @param f1 the first FuzzyNumber number.
     * @param f2 the second FuzzyNumber number.
     * @return the membership degree for the fgt operator.
     * @throws FuzzyConstraintException in case of error.
     */
    public Double Fgt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Discrete implementation for the necessity greater than operator.
     * @param f1 the first FuzzyNumber number.
     * @param f2 the second FuzzyNumber number.
     * @return the membership degree for the fgt operator.
     * @throws FuzzyConstraintException in case of error.
     */
    public Double Nfgt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Discrete implemetation for the fuzzy greater or equal operator.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Fgeq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Implementation for the necessity fuzzy greater or equal.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Nfgeq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Implementation for the fuzzy less than 
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Flt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Necessity fuzzy less than
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Nflt(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Fuzzy less or equal to
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Fleq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Necessity fuzzy less or equal to.
     * @param f1
     * @param f2
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Nfleq(FuzzyNumber f1, FuzzyNumber f2) throws FuzzyConstraintException;

    /**
     * Much greater than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Mgt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException;

    /**
     * Necessity much greater than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Nmgt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException;

    /**
     * Much less than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Mlt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException;

    /**
     * Necessity much less than
     * @param f1
     * @param f2
     * @param much
     * @return
     * @throws FuzzyConstraintException 
     */
    public Double Nmlt(FuzzyNumber f1, FuzzyNumber f2, Double much) throws FuzzyConstraintException;
}
