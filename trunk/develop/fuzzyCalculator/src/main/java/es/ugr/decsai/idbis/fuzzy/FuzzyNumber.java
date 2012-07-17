/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.idbis.fuzzy;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public abstract class FuzzyNumber implements FuzzyOperators{
    /**
     * A function returning the evaluation in the domain.
     * @param d a value in the domain.
     * @return a value in the interval [0,1] with the membership degree to the fuzzy number.
     * @throws FuzzyConstraintException 
     */
     public abstract Double evaluate(Double d) throws FuzzyConstraintException;
    
}
