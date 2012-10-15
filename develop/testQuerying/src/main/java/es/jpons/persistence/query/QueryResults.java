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

package es.jpons.persistence.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper class for the results in a temporal query.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class QueryResults {
    protected List entities;
    protected List<Double> satisfactionDegree;
    protected List<Double> disatisfactionDegree;

    public QueryResults(List entities) {
        this.entities = entities;
        satisfactionDegree = new ArrayList<Double>(entities.size());
    }
    
    
    
    public Double getSatisfactionDegree(int pos){
        return satisfactionDegree.get(pos);
    }
    
    public void setSatisfactionDegree(int pos, Double degree){
        satisfactionDegree.set(pos, degree);
    }

    public List<Double> getDisatisfactionDegree() {
        return disatisfactionDegree;
    }
    
    public boolean isEmpty(){
        return entities.isEmpty();
    }
    
    
    
    

}
