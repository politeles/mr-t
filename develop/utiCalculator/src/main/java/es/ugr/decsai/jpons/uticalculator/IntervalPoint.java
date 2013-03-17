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

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 06/03/2013
 *
 */
public class IntervalPoint {

    double start;
    double end;
    double tx;
    double ty;
    double membership;

    public IntervalPoint(double start, double end, double membership) {
        this.start = start;
        this.end = end;
        this.membership = membership;
        toTM();
    }

    private void toTM() {
        tx = (start + end) / 2;
        ty = (end - start) / 2;
    }
}
