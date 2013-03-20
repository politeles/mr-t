/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.jpons.uticalculator;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class TriangularDistribution<T extends Number> {
    T leftSide;
    T core;
    T rightSide;

    public TriangularDistribution(T leftSide, T core, T rightSide) {
        this.leftSide = leftSide;
        this.core = core;
        this.rightSide = rightSide;
    }

    public T getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(T leftSide) {
        this.leftSide = leftSide;
    }

    public T getCore() {
        return core;
    }

    public void setCore(T core) {
        this.core = core;
    }

    public T getRightSide() {
        return rightSide;
    }

    public void setRightSide(T rightSide) {
        this.rightSide = rightSide;
    }

  
}
