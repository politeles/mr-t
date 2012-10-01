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

package es.jpons.persistence.interceptor;

import java.io.Serializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;

/**
 * Interceptor for the temporal dml.
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 * First version 28/09/2012
 * 
 */
public class TemporalInterceptor extends EmptyInterceptor{

    private Session session;
    private static Logger log = LogManager.getLogger(
            TemporalInterceptor.class.getName());

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
//        return super.onSave(entity, id, state, propertyNames, types);
        
        log.error("Saved object");
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        super.onDelete(entity, id, state, propertyNames, types);
    }
    
    
    
}
