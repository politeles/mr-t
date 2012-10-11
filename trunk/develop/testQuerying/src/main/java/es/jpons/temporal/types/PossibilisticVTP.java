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

import es.jpons.persistence.constants.OpenInterval;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Possibilistic Valid-time period. This is a class for representing a
 * possibilistic valid-time interval. It is composed by a possibilistic starting
 * point, a possibilistic ending point plus the triangular representation for
 * each time.
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 02/10/2012
 *
 */
@Embeddable
public class PossibilisticVTP implements Serializable {

    /**
     * The class is composed by two time points, also a triangular
     * representation is provided.
     */
    protected Date startMP;
    protected Long startLeft;
    protected Long startRight;
    protected Date endMP;
    protected Long endLeft;
    protected Long endRight;
    protected Long ix;
    protected Long iy;
    protected OpenInterval side;

//    @Embedded
//     @Type(type = "es.jpons.temporal.types.PossibilisticTPType")
//    @Columns(columns={
//        @Column(name="startMP"),
//        @Column(name="startR"),
//        @Column(name="startL")
//    })
//    protected PossibilisticTP startVT;
//    @Embedded
//    @Type(type = "es.jpons.temporal.types.PossibilisticTPType")
//    @Columns(columns={
//        @Column(name="endMP"),
//        @Column(name="endR"),
//        @Column(name="endL")
//    })
//    protected PossibilisticTP endVT;
//    protected TimeIntervalTM intervalTM;
    /**
     * The default constructor.
     */
    public PossibilisticVTP() {
    }

    /**
     * Constructor with both starting and ending points.
     *
     * @param startVT The possibilistic starting point.
     * @param endVT The possibilistic ending point.
     */
    public PossibilisticVTP(PossibilisticTP startVT, PossibilisticTP endVT) {
//        this.startVT = startVT;
//        this.endVT = endVT;
    }
/**
 * Constructor for both starting and ending points
 * @param startMP The starting main point
 * @param startLeft The left side of the main point
 * @param startRight The right side of the main point
 * @param endMP The ending main point.
 * @param endLeft The left side of the end point.
 * @param endRight  The right side of the end point.
 */
    public PossibilisticVTP(Date startMP, Long startLeft, Long startRight, Date endMP, Long endLeft, Long endRight) {
        this.startMP = startMP;
        this.startLeft = startLeft;
        this.startRight = startRight;
        this.endMP = endMP;
        this.endLeft = endLeft;
        this.endRight = endRight;
        //run the conversion to the triangular model
        convertToTM();
    }

    public PossibilisticVTP(Date mainPoint, Long left, Long right, OpenInterval side) {
        switch (side) {
            case UC:
                this.startMP = mainPoint;
                this.startLeft = left;
                this.startRight = right;
                this.side = OpenInterval.UC;
                break;
            case FB:
                this.endMP = mainPoint;
                this.endLeft = left;
                this.endRight = right;
                this.side = OpenInterval.FB;
                break;
        }
    }
    
    
    public PossibilisticVTP(Integer sday,Integer smonth,Integer syear,Integer eday,Integer emonth,Integer eyear){
        DateTime dateStartingMainPoint,dateStartingLeft,dateStartingRight;
            DateTime dateEndingMainPoint,dateEndingLeft,dateEndingRight;
            
            dateStartingMainPoint = new DateTime(syear,smonth, sday, 0, 0);
            
          
            dateStartingLeft = dateStartingMainPoint.minusDays(3);
            dateStartingRight = dateStartingMainPoint.plusDays(3);
            
            Duration d = new Duration(dateStartingLeft, dateStartingMainPoint);
            Duration d1 = new Duration(dateStartingMainPoint, dateStartingRight);
            
            
            
            
            dateEndingMainPoint = new DateTime(eyear,emonth, eday, 0, 0);
            dateEndingLeft = dateEndingMainPoint.minusDays(3);
            dateEndingRight = dateEndingMainPoint.plusDays(3);
            
            Duration d2 = new Duration(dateEndingLeft, dateEndingMainPoint);
            Duration d3 = new Duration(dateEndingMainPoint, dateEndingRight);
            
            
            PossibilisticTP start, end;
            PossibilisticVTP pvp;
            
//            start = new PossibilisticTP(
//                    dateStartingMainPoint.toDate(),
//                    dateStartingLeft.toDate(),
//                    dateStartingRight.toDate());
//            end = new PossibilisticTP(   
//                    dateEndingMainPoint.toDate(),
//                    dateEndingLeft.toDate(),
//                    dateEndingRight.toDate());
            
            pvp = new PossibilisticVTP(dateStartingMainPoint.toDate(),d.getMillis(),d1.getMillis(),dateEndingMainPoint.toDate(),d2.getMillis(),d3.getMillis());
           
    }

    /**
     * Function to convert from the ill-known value to the triangular model.
     */
    private void convertToTM() {
        if (this.startMP != null
                && this.endMP != null) {
            this.ix = (this.endMP.getTime() + this.startMP.getTime()) / 2;
            this.iy = (this.endMP.getTime() - this.startMP.getTime()) / 2;
        }


    }

    /**
     * Function that converts from the triangular model to the ill-known model.
     */
    private void convertToIK() {
        if (this.ix != null
                && this.iy != null) {
            this.startMP = new Date(this.ix - this.iy);
            this.endMP = new Date(this.ix + this.iy);
        }
    }

    public Date getStartMP() {
        return startMP;
    }

    public void setStartMP(Date startMP) {
        this.startMP = startMP;
    }

    public Long getStartLeft() {
        return startLeft;
    }

    public void setStartLeft(Long startLeft) {
        this.startLeft = startLeft;
    }

    public Long getStartRight() {
        return startRight;
    }

    public void setStartRight(Long startRight) {
        this.startRight = startRight;
    }

    public Date getEndMP() {
        return endMP;
    }

    public void setEndMP(Date endMP) {
        this.endMP = endMP;
    }

    public Long getEndLeft() {
        return endLeft;
    }

    public void setEndLeft(Long endLeft) {
        this.endLeft = endLeft;
    }

    public Long getEndRight() {
        return endRight;
    }

    public void setEndRight(Long endRight) {
        this.endRight = endRight;
    }

    public Long getIx() {
        return ix;
    }

    public void setIx(Long ix) {
        this.ix = ix;
    }

    public Long getIy() {
        return iy;
    }

    public void setIy(Long iy) {
        this.iy = iy;
    }

    public OpenInterval getSide() {
        return side;
    }

    public void setSide(OpenInterval side) {
        this.side = side;
    }
    
    

//    public PossibilisticTP getStartVT() {
////        return startVT;
//    }
//    public void setStartVT(PossibilisticTP startVT) {
//        this.startVT = startVT;
//    }
//    public PossibilisticTP getEndVT() {
//        return endVT;
//    }
//
//    public void setEndVT(PossibilisticTP endVT) {
//        this.endVT = endVT;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
//        hash = 53 * hash + (this.startVT != null ? this.startVT.hashCode() : 0);
//        hash = 53 * hash + (this.endVT != null ? this.endVT.hashCode() : 0);
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
        final PossibilisticVTP other = (PossibilisticVTP) obj;
//        if (this.startVT != other.startVT && (this.startVT == null || !this.startVT.equals(other.startVT))) {
//            return false;
//        }
//        if (this.endVT != other.endVT && (this.endVT == null || !this.endVT.equals(other.endVT))) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        String result = new String();
        
        if(this.getSide()!=null && this.getSide().compareTo(OpenInterval.FB)==0){
            result += " [ FB ,";
        }else{
            DateTime mp = new DateTime(this.startMP);
            DateTime left = new DateTime(mp.minus(this.startLeft));
            DateTime right = new DateTime(mp.plus(this.startRight));
            result += " [ ( " + left + " , " + mp + " , " + right + " ) ,";
        }
        
        if(this.getSide()!=null && this.getSide().compareTo(OpenInterval.UC)==0){
            result += "  UC ";
        }else{
             DateTime mp = new DateTime(this.endMP);
            DateTime left = new DateTime(mp.minus(this.endLeft));
            DateTime right = new DateTime(mp.plus(this.endRight));
            result += "  ( " + left + " , " + mp + " , " + right + " ) ]";
        }
        
        
        
        
        return result;
    }
}
