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

package es.jpons.persistence;

import es.jpons.persistence.exception.TemporalException;
import es.jpons.temporal.types.PossibilisticVTP;
import es.jpons.temporal.types.TemporalPK;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;

/**
 *
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 15/10/2012
 * 
 */
public class TimeUtils {
    protected static Logger log = Logger.getLogger(TimeUtils.class);
    
    /**
     * Obtains the primary key of a given temporal object
     *
     * @param temporalEntity The entity
     * @return The primary key.
     * @throws TemporalException
     */
    public static TemporalPK getPK(Object temporalEntity) throws TemporalException {
        if (temporalEntity == null) {
            return null;
        } else {
            TemporalPK key;
            try {
                key = (TemporalPK) temporalEntity.getClass().getMethod("getTid", new Class[]{}).invoke(temporalEntity, null);
                return key;
            } catch (Exception ex) {
                log.error(" Error obtaining the pk of a temporal object");
                throw new TemporalException(ex);
            }

        }
    }
    
    /**
     * Determines if the given entity is a valid-time object or not.
     *
     * @param entity The entity to persist.
     * @return True if the entity is a valid-time object, false otherwise.
     */
    public static PossibilisticVTP getValidTime(Object entity) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = entity.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        PossibilisticVTP validTime = null;
        boolean found = false;
        for (int i = 0; i < declaredFields.length && !found; i++) {
            if (declaredFields[i].getType().equals(PossibilisticVTP.class)) {
                found = true;
//                validTime = (PossibilisticVTP) declaredFields[i].get(entity);
                String fieldName = declaredFields[i].getName();
                fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                Class [] noparams = {};
                Object invoke = entity.getClass().getMethod(fieldName, new Class[]{}).invoke(entity, null);
                validTime = (PossibilisticVTP) invoke;
            }
        }
        return validTime;
    }

}
