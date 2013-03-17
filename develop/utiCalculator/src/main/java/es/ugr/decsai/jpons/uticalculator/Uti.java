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

/**
 * Uncertain time interval
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 06/03/2013
 *
 */
public class Uti {

    /**
     * Coordinates in the cartesian model
     */
    protected double start;
    protected double end;
    protected double start1;
    protected double start2;
    protected double end1;
    protected double end2;
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
    public Uti(double start1,double start,double start2 , double end1, double end, double end2) {
        this.start = start;
        this.end = end;
        this.start1 = start1;
        this.start2 = start2;
        this.end1 = end1;
        this.end2 = end2;
    }

    public List<IntervalPoint> getIntervalPoints() {
        int iterationsStart = (int) ((start2 - start1) * iterations);
        int iterationsEnd = (int) ((end2 - end1) * iterations);

        int iterations = iterationsStart * iterationsEnd;
        List<IntervalPoint> points = new ArrayList<IntervalPoint>(iterations);

        for (int i = 0; i < iterationsStart; i++) {
            for (int j = 0; j < iterationsEnd; j++) {
                double ipStart = start1 + ((double)i /(double) this.iterations);
                double ipEnd = end1 + ((double) j /(double) this.iterations);

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
}
