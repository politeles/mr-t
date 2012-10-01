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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.metamodel.binding.HibernateTypeDescriptor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * The hibernate type for the primary key.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 01/10/2012
 * 
 */
public class TemporalPKType implements CompositeUserType{

    public String[] getPropertyNames() {
        return new String[]{"id","vid"};
    }

    public Type[] getPropertyTypes() {
        return new Type[]{
        (Type)StandardBasicTypes.INTEGER, (Type)StandardBasicTypes.INTEGER
        };
        }
    

    public Object getPropertyValue(Object o, int i) throws HibernateException {
        TemporalPK tpk = (TemporalPK)o;
        Object result= null;
        switch(i){
            case 0: result = (Object) tpk.getId();
                break;
            case 1: result = (Object) tpk.getVid();
                break; 
        }
        return result;
    }

    public void setPropertyValue(Object component, int property, Object val) throws HibernateException {
        TemporalPK tpk = (TemporalPK)component;
        Integer  set = (Integer)val;
        switch(property){
            case 0: 
                tpk.setId(set);
                break;
            case 1:
                tpk.setVid(set);
                break;
        }
    }

    public Class returnedClass() {
        return TemporalPK.class;
    }

    public boolean equals(Object o, Object o1) throws HibernateException {
        TemporalPK tp1,tp2;
        tp1 = (TemporalPK) o;
        tp2 = (TemporalPK) o1;
        boolean result = false;
        if(tp1.getId() == tp2.getId() && tp1.getVid() == tp2.getVid()){
            result = true;
        }
        return result;
        
    }

    public int hashCode(Object o) throws HibernateException {
        return ((TemporalPK)o).hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor si, Object o) throws HibernateException, SQLException {
        Integer id = (Integer) StandardBasicTypes.INTEGER.nullSafeGet(rs, names[0], si);
        Integer vid = (Integer) StandardBasicTypes.INTEGER.nullSafeGet(rs, names[1], si);
        
        return new TemporalPK(id,vid);
        
    }

    public void nullSafeSet(PreparedStatement ps, Object o, int index, SessionImplementor si) throws HibernateException, SQLException {
        TemporalPK value = (TemporalPK)o;
        Integer id = value.getId();
        Integer vid = value.getVid();
        StandardBasicTypes.INTEGER.nullSafeSet(ps, id, index, si);
        StandardBasicTypes.INTEGER.nullSafeSet(ps, id, index+1, si);
        
    }

    public Object deepCopy(Object o) throws HibernateException {
        TemporalPK pK = (TemporalPK) o;
        return new TemporalPK(pK.getId(), pK.getVid());
    }

    public boolean isMutable() {
        return true;
    }

    public Serializable disassemble(Object o, SessionImplementor si) throws HibernateException {
        return (Serializable) deepCopy(o);
    }

    public Object assemble(Serializable srlzbl, SessionImplementor si, Object o) throws HibernateException {
        return deepCopy(o);
    }

    public Object replace(Object o, Object o1, SessionImplementor si, Object o2) throws HibernateException {
        return deepCopy(o);
    }

}
