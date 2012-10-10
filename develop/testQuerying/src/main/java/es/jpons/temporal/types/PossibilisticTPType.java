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
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * Possibilistic Time Point Type.
 * This class allows the persistence in Hibernate for the class 
 * Possibilistic Time Point.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 02/10/2012
 * 
 */
public class PossibilisticTPType implements CompositeUserType{
    private static final String MAIN_POINT = "mainpoint";
    private static final String LEFT_SHIFT = "leftshift";
    private static final String RIGHT_SHIFT = "rightshift";

    public PossibilisticTPType() {
        System.out.println("Creacion");
    }
    
    
    
    
    public String[] getPropertyNames() {
        
        return new String[]{MAIN_POINT,LEFT_SHIFT,RIGHT_SHIFT};
    }

    public Type[] getPropertyTypes() {
        return new Type[]{
          StandardBasicTypes.DATE,
          StandardBasicTypes.DATE,
          StandardBasicTypes.DATE
        };
    }

    public Object getPropertyValue(Object o, int i) throws HibernateException {
        PossibilisticTP ptp = (PossibilisticTP)o;
        Object result = null;
        switch(i){
            case 0: result = (Object) ptp.mainPoint;
                break;
            case 1: result = (Object) ptp.leftShift;
                break;
            case 2: result = (Object) ptp.rightShift;
                break;
        }
        return result;
    }

    public void setPropertyValue(Object component, int property, Object val) throws HibernateException {
        PossibilisticTP ptp = (PossibilisticTP) component;
        Date date = (Date) val;
        switch(property){
            case 0: ptp.setMainPoint(date);
                break;
            case 1: ptp.setLeftShift(date);
                break;
            case 2: ptp.setRightShift(date);
                break;
                
        }
    }

    public Class returnedClass() {
        return PossibilisticTP.class;
    }

    public boolean equals(Object o, Object o1) throws HibernateException {
        PossibilisticTP p1,p2;
        p1 = (PossibilisticTP) o;
        p2 = (PossibilisticTP) o1;
        
        boolean result = false;
        if(p1.getMainPoint().compareTo(p2.getMainPoint())==0){
            result = true;
        }
        return result;
    }

    public int hashCode(Object o) throws HibernateException {
        return ((PossibilisticTP)o).hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor si, Object o) throws HibernateException, SQLException {
       Date mainpoint = (Date) StandardBasicTypes.DATE.nullSafeGet(rs, names[0], si);
       Date left = (Date)StandardBasicTypes.DATE.nullSafeGet(rs, names[1], si);
       Date right = (Date) StandardBasicTypes.DATE.nullSafeGet(rs, names[2], si);
       
       return new PossibilisticTP(mainpoint, left, right);
       
    }

    public void nullSafeSet(PreparedStatement ps, Object o, int index, SessionImplementor si) throws HibernateException, SQLException {
        PossibilisticTP value = (PossibilisticTP) o;
        Date mainpoint = value.getMainPoint();
        Date left = value.getLeftShift();
        Date right = value.getRightShift();
        
        StandardBasicTypes.DATE.nullSafeSet(ps, mainpoint, index, si);
        StandardBasicTypes.DATE.nullSafeSet(ps, left, index+1, si);
        StandardBasicTypes.DATE.nullSafeSet(ps, right, index+2, si);
    }

    public Object deepCopy(Object o) throws HibernateException {
        PossibilisticTP val = (PossibilisticTP) o;
        //TODO: review this when the implementation change
        return new PossibilisticTP(val.getMainPoint(), val.getLeftShift(), val.getRightShift());
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
