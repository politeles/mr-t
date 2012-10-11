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

import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es> First version
 * 27/09/2012
 *
 */
@Entity
@Table(name = "employee", catalog = "")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "vid")
//    private Integer vid;
    @EmbeddedId
    @Type(type = "es.jpons.temporal.types.TemporalPKType")
    @Columns(columns={
        @Column(name="id"),
        @Column(name="vid")
    })
    private TemporalPK tid;
    // Version ID.
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    //valid time
    @Embedded
    @Columns(columns={
        @Column(name="startMP"),
        @Column(name="startR"),
        @Column(name="startL"),
        @Column(name="startMP"),
        @Column(name="startR"),
        @Column(name="startL")
    })
    protected PossibilisticVTP pvp;
    
    
    
    public Employee() {
    }

    public Employee(TemporalPK pk, String name) {
//        this.tid = new TemporalEmployeePK(id, vid);
//        this.id = id;
//        this.vid = vid;
        this.tid = pk;
        this.name = name;
    }

    public TemporalPK getTid() {
        return tid;
    }

    public void setTid(TemporalPK tid) {
        this.tid = tid;
    }

    public PossibilisticVTP getPvp() {
        return pvp;
    }

    public void setPvp(PossibilisticVTP pvp) {
        this.pvp = pvp;
    }
    

//    public TemporalEmployeePK getTid() {
//        return tid;
//    }
//
//    public void setTid(TemporalEmployeePK tid) {
//        this.tid = tid;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getVid() {
//        return vid;
//    }
//
//    public void setVid(Integer vid) {
//        this.vid = vid;
//    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if ((this.tid.getId() == null) ? (other.getTid().getId() != null) : !this.tid.getId().equals(other.getTid().getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.tid.getId() != null ? this.tid.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + "[emp=" + this.tid.getId() + "]";
    }
   }


