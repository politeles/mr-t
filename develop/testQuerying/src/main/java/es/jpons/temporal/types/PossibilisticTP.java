/*
 * Copyright (C) 2012 Jose Enrique Pons Frías <jpons@decsai.ugr.es>.
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
package es.jpons.temporal.types;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 * Possibilistic time point. It stores the main time point as well as the
 * triangular representation of the time point.
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 02/10/2012
 *
 */
@Embeddable
public class PossibilisticTP implements Serializable {

    
    protected Date mainPoint;
    protected Date leftShift;
    protected Date rightShift;
//    protected Granularity leftGranularity;
//    protected Granularity rightGranularity;
//    protected Granularity mainPointGranularity;

    /**
     * Default constructor with no utility in fact.
     */
    public PossibilisticTP() {
    }

    /**
     * Main constructor with the triangular possibility distribution.
     *
     * @param mainPoint
     * @param leftShift
     * @param rightShift
     */
    public PossibilisticTP(Date mainPoint, Date leftShift, Date rightShift) {
        this.mainPoint = mainPoint;
        this.leftShift = leftShift;
        this.rightShift = rightShift;


    }

    /**
     * Constructor with all the fields.
     *
     * @param mainPoint
     * @param leftShift
     * @param rightShift
     * @param leftGranularity
     * @param rightGranularity
     * @param mainPointGranularity
     */
    public PossibilisticTP(Date mainPoint, Date leftShift, Date rightShift, Granularity leftGranularity, Granularity rightGranularity, Granularity mainPointGranularity) {
        this.mainPoint = mainPoint;
        this.leftShift = leftShift;
        this.rightShift = rightShift;
//        this.leftGranularity = leftGranularity;
//        this.rightGranularity = rightGranularity;
//        this.mainPointGranularity = mainPointGranularity;
    }

    public Date getMainPoint() {
        return mainPoint;
    }

    public void setMainPoint(Date mainPoint) {
        this.mainPoint = mainPoint;
    }

    public Date getLeftShift() {
        return leftShift;
    }

    public void setLeftShift(Date leftShift) {
        this.leftShift = leftShift;
    }

    public Date getRightShift() {
        return rightShift;
    }

    public void setRightShift(Date rightShift) {
        this.rightShift = rightShift;
    }

//    public Granularity getLeftGranularity() {
//        return leftGranularity;
//    }
//
//    public void setLeftGranularity(Granularity leftGranularity) {
//        this.leftGranularity = leftGranularity;
//    }
//
//    public Granularity getRightGranularity() {
//        return rightGranularity;
//    }
//
//    public void setRightGranularity(Granularity rightGranularity) {
//        this.rightGranularity = rightGranularity;
//    }
//
//    public Granularity getMainPointGranularity() {
//        return mainPointGranularity;
//    }
//
//    public void setMainPointGranularity(Granularity mainPointGranularity) {
//        this.mainPointGranularity = mainPointGranularity;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.mainPoint != null ? this.mainPoint.hashCode() : 0);
        hash = 29 * hash + (this.leftShift != null ? this.leftShift.hashCode() : 0);
        hash = 29 * hash + (this.rightShift != null ? this.rightShift.hashCode() : 0);
//        hash = 29 * hash + (this.leftGranularity != null ? this.leftGranularity.hashCode() : 0);
//        hash = 29 * hash + (this.rightGranularity != null ? this.rightGranularity.hashCode() : 0);
//        hash = 29 * hash + (this.mainPointGranularity != null ? this.mainPointGranularity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PossibilisticTP other = (PossibilisticTP) obj;
        if (this.mainPoint != other.mainPoint && (this.mainPoint == null || !this.mainPoint.equals(other.mainPoint))) {
            return false;
        }
        if (this.leftShift != other.leftShift && (this.leftShift == null || !this.leftShift.equals(other.leftShift))) {
            return false;
        }
        if (this.rightShift != other.rightShift && (this.rightShift == null || !this.rightShift.equals(other.rightShift))) {
            return false;
        }
//        if (this.leftGranularity != other.leftGranularity) {
//            return false;
//        }
//        if (this.rightGranularity != other.rightGranularity) {
//            return false;
//        }
//        if (this.mainPointGranularity != other.mainPointGranularity) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "PossibilisticTP{" + "mainPoint=" + mainPoint + '}';
    }
}
