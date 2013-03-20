/*
 * Copyright (C) 2013 Jose Enrique Pons Frías <jpons@decsai.ugr.es>.
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
package es.ugr.decsai.jpons.uticalculator;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Uncertain time interval
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 06/03/2013
 *
 */
public class Uti {

    /**
     * Coordinates in the time line
     */
    protected double start;
    protected double end;
    protected double start1;
    protected double start2;
    protected double end1;
    protected double end2;
    
    DateTime dtStart;
    DateTime dtStart1;
    DateTime dtStart2;
    DateTime dtEnd;
    DateTime dtEnd1;
    DateTime dtEnd2;
    // screen coordinates:
    double scs;
    double scs1;
    double scs2;
    double sce;
    double sce1;
    double sce2;
    
    protected void toScreenCoords(){
        if(dtStart == null 
                || dtStart1 == null
                || dtStart2 == null
                || dtEnd == null
                || dtEnd1 == null
                || dtEnd2 == null){
            return;
        }
        scs = convertUnits(dtStart);
        scs1 = convertUnits(dtStart1);
        scs2 = convertUnits(dtStart2);
        
        sce = convertUnits(dtEnd);
        sce1 = convertUnits(dtEnd1);
        sce2 = convertUnits(dtEnd2);
        
    }
    
    protected double convertUnits(DateTime t){
        double cents = t.getDayOfYear()*100/365;
        return t.getYear() + 0.01 * cents;
        
    }
    
    protected  int iterations = 100;
    
    public void setIterations(int iter){
        iterations = iter;
    }

    /**
     * computes the coordinates in the tm model
     */
    protected double getTx(double a, double b) {
        return (a + b) / 2;
    }

    protected double getTy(double a, double b) {
        return (b - a) / 2;
    }

    
    public double getTx(){
        return getTx(start, end);
    }
    
    public double getTy(){
        return getTy(start,end);
    }
    
    public double getScreenX(){
        return getTx(scs,sce);
    }
    
    public double getScreenY(){
        return getTy(scs,sce);
    }
    
    
    /**
     * Function that computes a triangular membership function
     *
     * @param start usually D-a
     * @param core usually D
     * @param end usually D+b
     * @param value The value to compute the membership
     * @return a value in the unit interval [0,1] that represents the membership
     */
    protected double triangularMF(double start, double core, double end, double value) {
        double membership = 0D;
        if (value == core) {
            membership = 1D;
        } else if (value >= start && value < core) {
            membership = (value - start) / (core - start);
        } else if (value >= core && value < end) {
            membership = (end - value) / (end - core);
        }
        return membership;
    }

    protected double muI(double a, double b) {
        double membership = 0D;
        double s = triangularMF(start1, start, start2, a);
        double e = triangularMF(end1, end, end2, b);

        membership = Math.min(s, e);

        return membership;
    }

    /**
     *
     * @param start
     * @param end
     * @param start1
     * @param start2
     * @param end1
     * @param end2
     */
    public Uti(double start1, double start, double start2, double end1, double end, double end2) {
        this.start = start;
        this.end = end;
        this.start1 = start1;
        this.start2 = start2;
        this.end1 = end1;
        this.end2 = end2;
        
        this.dtStart = new DateTime(((Double)start).longValue());
        this.dtStart1 = new DateTime(((Double)start1).longValue());
        this.dtStart2 = new DateTime(((Double)start2).longValue());
        this.dtEnd = new DateTime(((Double)end).longValue());
        this.dtEnd1 = new DateTime(((Double)end1).longValue());
        this.dtEnd2 = new DateTime(((Double)end2).longValue());
    }
    
    public Uti(DateTime start1,DateTime start, DateTime start2, DateTime end1, DateTime end,DateTime end2){
        this.start1 = toDouble(start1);
        this.start = toDouble(start);
        this.start2 = toDouble(start2);
        
        this.end1 = toDouble(end1);
        this.end = toDouble(end);
        this.end2 = toDouble(end2);
        
        this.dtStart1 = start1;
        this.dtStart = start;
        this.dtStart2 = start2;
        
        this.dtEnd1 = end1;
        this.dtEnd2 = end2;
        this.dtEnd = end;
        
        toScreenCoords();
        
    }
    
    private double toDouble(DateTime t){
        if(t==null){
            return 0;
        }
      return ((Long) t.getMillis()).doubleValue();
    }

    public List<IntervalPoint> getIntervalPoints() {
        int iterationsStart = (int) ((start2 - start1) * iterations);
        int iterationsEnd = (int) ((end2 - end1) * iterations);

        int iterations = iterationsStart * iterationsEnd;
        List<IntervalPoint> points = new ArrayList<IntervalPoint>(iterations);

        for (int i = 0; i < iterationsStart; i++) {
            for (int j = 0; j < iterationsEnd; j++) {
                double ipStart = start1 + ((double) i / (double) this.iterations);
                double ipEnd = end1 + ((double) j / (double) this.iterations);

                IntervalPoint ip = new IntervalPoint(ipStart, ipEnd, muI(ipStart, ipEnd));
                points.add(ip);
            }
        }


        return points;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getStart1() {
        return start1;
    }

    public double getStart2() {
        return start2;
    }

    public double getEnd1() {
        return end1;
    }

    public double getEnd2() {
        return end2;
    }

    public int getIterations() {
        return iterations;
    }

    public DateTime getDtStart() {
        return dtStart;
    }

    public void setDtStart(DateTime dtStart) {
        this.dtStart = dtStart;
    }

    public DateTime getDtStart1() {
        return dtStart1;
    }

    public void setDtStart1(DateTime dtStart1) {
        this.dtStart1 = dtStart1;
    }

    public DateTime getDtStart2() {
        return dtStart2;
    }

    public void setDtStart2(DateTime dtStart2) {
        this.dtStart2 = dtStart2;
    }

    public DateTime getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(DateTime dtEnd) {
        this.dtEnd = dtEnd;
    }

    public DateTime getDtEnd1() {
        return dtEnd1;
    }

    public void setDtEnd1(DateTime dtEnd1) {
        this.dtEnd1 = dtEnd1;
    }

    public DateTime getDtEnd2() {
        return dtEnd2;
    }

    public void setDtEnd2(DateTime dtEnd2) {
        this.dtEnd2 = dtEnd2;
    }
    
    
}
