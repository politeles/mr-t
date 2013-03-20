/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.historydb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByR1", query = "SELECT t FROM Test t WHERE t.r1 = :r1"),
    @NamedQuery(name = "Test.findByR2", query = "SELECT t FROM Test t WHERE t.r2 = :r2")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "r1")
    private Integer r1;
    @Column(name = "r2")
    private String r2;

    public Test() {
    }

    public Test(Integer r1) {
        this.r1 = r1;
    }

    public Integer getR1() {
        return r1;
    }

    public void setR1(Integer r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (r1 != null ? r1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.r1 == null && other.r1 != null) || (this.r1 != null && !this.r1.equals(other.r1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.ugr.decsai.historydb.model.Test[ r1=" + r1 + " ]";
    }
    
}
