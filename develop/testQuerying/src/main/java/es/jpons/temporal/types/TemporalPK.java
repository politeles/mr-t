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
import javax.persistence.Embeddable;

/**
 * Persistence class for the primary key in temporal databases.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 01/10/2012
 * 
 */
@Embeddable
public class TemporalPK implements Serializable{
    
    protected Integer id;
    protected Integer vid;

    public TemporalPK() {
    }

    public TemporalPK(Integer id) {
        this.id = id;
    }

    public TemporalPK(Integer id, Integer vid) {
        this.id = id;
        this.vid = vid;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 83 * hash + (this.vid != null ? this.vid.hashCode() : 0);
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
        final TemporalPK other = (TemporalPK) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.vid != other.vid && (this.vid == null || !this.vid.equals(other.vid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TemporalPK{" + "id=" + id + ", vid=" + vid + '}';
    }
    
    
    

}
