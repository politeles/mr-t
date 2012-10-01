/*
 * Copyright (C) 2012 University of Granada, Department of Computer Science and Artificial Intelligence.
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

package es.ugr.decsai.jpons.testapplication.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 28/09/2012
 * 
 */
    @Embeddable
    public class TemporalEmployeePK implements Serializable {

       
        @Basic(optional = false)
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        
        @Basic(optional = false)
        @Column(name = "vid")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer vid;

        public TemporalEmployeePK() {
        }

        public TemporalEmployeePK(Integer id, Integer vid) {
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
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 47 * hash + (this.vid != null ? this.vid.hashCode() : 0);
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
        final TemporalEmployeePK other = (TemporalEmployeePK) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TemporalEmployeePK{" + "id=" + id + ", vid=" + vid + '}';
    }
        
        
 
}
