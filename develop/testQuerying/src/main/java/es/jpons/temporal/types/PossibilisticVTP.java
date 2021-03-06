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
import java.rmi.server.Skeleton;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
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
    protected Long startMP;
    protected Long startLeft;
    protected Long startRight;
    protected Long endMP;
    protected Long endLeft;
    protected Long endRight;
    protected Long ix;
    protected Long iy;
    protected OpenInterval side;
    @Transient
    protected Date startDate;
    @Transient
    protected Date endDate;

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
     *
     * @param startMP The starting main point
     * @param startLeft The left side of the main point
     * @param startRight The right side of the main point
     * @param endMP The ending main point.
     * @param endLeft The left side of the end point.
     * @param endRight The right side of the end point.
     */
    public PossibilisticVTP(Date startMP, Long startLeft, Long startRight, Date endMP, Long endLeft, Long endRight) {
        this.startMP = startMP.getTime();
        this.startLeft = startLeft;
        this.startRight = startRight;
        this.endMP = endMP.getTime();
        this.endLeft = endLeft;
        this.endRight = endRight;

        this.startDate = startMP;
        this.endDate = endMP;
        //run the conversion to the triangular model
        convertToTM();
    }

    public PossibilisticVTP(Date mainPoint, Long left, Long right, OpenInterval side) {
        switch (side) {
            case UC:
                this.startMP = mainPoint.getTime();
                this.startLeft = left;
                this.startRight = right;
                this.side = OpenInterval.UC;
                this.startDate = mainPoint;
                break;
            case FB:
                this.endMP = mainPoint.getTime();
                this.endLeft = left;
                this.endRight = right;
                this.side = OpenInterval.FB;
                this.endDate = mainPoint;
                break;
        }
    }

    /**
     * Constructor
     *
     * @param sday Starting day of month
     * @param smonth Starting month of year
     * @param syear Starting year
     * @param sLeftDays Number of days of the left starting margin.
     * @param sRightDays Number of days of the right starting margin.
     * @param eday Ending day of month.
     * @param emonth Ending month of year.
     * @param eyear Ending year.
     * @param eLeftDays Number of days of the ending margin.
     * @param eRightDays Number of days of the right ending margin.
     */
    public PossibilisticVTP(Integer sday, Integer smonth, Integer syear, Integer sLeftDays, Integer sRightDays, Integer eday, Integer emonth, Integer eyear, Integer eLeftDays, Integer eRightDays) {
        DateTime dateStartingMainPoint, dateStartingLeft, dateStartingRight;
        DateTime dateEndingMainPoint, dateEndingLeft, dateEndingRight;

        dateStartingMainPoint = new DateTime(syear, smonth, sday, 0, 0);


        dateStartingLeft = dateStartingMainPoint.minusDays(sLeftDays);
        dateStartingRight = dateStartingMainPoint.plusDays(sRightDays);

        Duration d = new Duration(dateStartingLeft, dateStartingMainPoint);
        Duration d1 = new Duration(dateStartingMainPoint, dateStartingRight);




        dateEndingMainPoint = new DateTime(eyear, emonth, eday, 0, 0);
        dateEndingLeft = dateEndingMainPoint.minusDays(eLeftDays);
        dateEndingRight = dateEndingMainPoint.plusDays(eRightDays);

        Duration d2 = new Duration(dateEndingLeft, dateEndingMainPoint);
        Duration d3 = new Duration(dateEndingMainPoint, dateEndingRight);


//            PossibilisticTP start, end;
        PossibilisticVTP pvp;

//            
//            start = new PossibilisticTP(
//                    dateStartingMainPoint.toDate(),
//                    dateStartingLeft.toDate(),
//                    dateStartingRight.toDate());
//            end = new PossibilisticTP(   
//                    dateEndingMainPoint.toDate(),
//                    dateEndingLeft.toDate(),
//                    dateEndingRight.toDate());

        //PossibilisticVTP(dateStartingMainPoint.toDate(),d.getMillis(),d1.getMillis(),dateEndingMainPoint.toDate(),d2.getMillis(),d3.getMillis());
        this.startMP = dateStartingMainPoint.getMillis();
        this.startLeft = d.getMillis();
        this.startRight = d1.getMillis();
        this.endMP = dateEndingMainPoint.getMillis();
        this.endLeft = d2.getMillis();
        this.endRight = d3.getMillis();
        this.startDate = dateStartingMainPoint.toDate();
        this.endDate = dateEndingMainPoint.toDate();

        convertToTM();

    }

    public PossibilisticVTP(Integer day, Integer month, Integer year, Integer leftDays, Integer rightDays, OpenInterval side) {
        DateTime dateMainPoint, dateLeft, dateRight;

        dateMainPoint = new DateTime(year, month, day, 0, 0);


        dateLeft = dateMainPoint.minusDays(leftDays);
        dateRight = dateMainPoint.plusDays(rightDays);

        Duration d = new Duration(dateLeft, dateMainPoint);
        Duration d1 = new Duration(dateMainPoint, dateRight);




        switch (side) {
            case UC:
                this.startMP = dateMainPoint.getMillis();
                this.startLeft = d.getMillis();
                this.startRight = d1.getMillis();
                this.startDate = dateMainPoint.toDate();
                this.side = OpenInterval.UC;
                break;
            case FB:
                this.endMP = dateMainPoint.getMillis();
                this.endLeft = d.getMillis();
                this.endRight = d1.getMillis();
                this.endDate = dateMainPoint.toDate();
                this.side = OpenInterval.FB;
                break;
        }

    }

    /**
     * Function to convert from the ill-known value to the triangular model.
     */
    private void convertToTM() {
        if (this.startMP != null
                && this.endMP != null) {
            this.ix = (this.endMP + this.startMP) / 2;
            this.iy = (this.endMP - this.startMP) / 2;
        }


    }

    /**
     * Function that converts from the triangular model to the ill-known model.
     */
    private void convertToIK() {
        if (this.ix != null
                && this.iy != null) {
            this.startMP = this.ix - this.iy;
            this.endMP = this.ix + this.iy;
        }
    }

    public Long getStartMP() {
        return startMP;
    }

    public void setStartMP(Long startMP) {
        this.startMP = startMP;
        if (startMP == null) {
            this.startDate = null;
        } else {
            this.startDate = new Date(startMP);
        }

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

    public Long getEndMP() {
        return endMP;
    }

    public void setEndMP(Long endMP) {
        this.endMP = endMP;
        if (endMP == null) {
            this.endDate = null;
        } else {
            this.endDate = new Date(endMP);
        }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        if (startDate != null) {
            this.startMP = startDate.getTime();
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        if (endDate != null) {
            this.endMP = endDate.getTime();
        }
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

        if (this.getSide() != null && this.getSide().compareTo(OpenInterval.FB) == 0) {
            result += " [ FB ,";
        } else {
            DateTime mp = new DateTime(this.startMP);
            DateTime left = new DateTime(mp.minus(this.startLeft));
            DateTime right = new DateTime(mp.plus(this.startRight));
            result += " [ ( " + left + " , " + mp + " , " + right + " ) ,";
        }

        if (this.getSide() != null && this.getSide().compareTo(OpenInterval.UC) == 0) {
            result += "  UC ";
        } else {
            DateTime mp = new DateTime(this.endMP);
            DateTime left = new DateTime(mp.minus(this.endLeft));
            DateTime right = new DateTime(mp.plus(this.endRight));
            result += "  ( " + left + " , " + mp + " , " + right + " ) ]";
        }




        return result;
    }
}
