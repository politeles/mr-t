/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.historydb.dao;

import es.ugr.decsai.historydb.model.Contents;
import es.ugr.decsai.jpons.uticalculator.Uti;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 * Class to deal with Contents
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class ContentDao {
    private  Session session;
    
   public ContentDao(Session s){
        this.session =s;
    }
    
    
    public List<Contents> getContentBetweenDates(Uti queriedTime){
        if(queriedTime==null){
            return null;
        }
//         Chronology chrono = GJChronology.getInstance();
//        DateTime start = new DateTime();
//        start.withChronology(chrono);
//        start.withMillis(((Double) queriedTime.getStart1()).longValue());
//        DateTime end = new DateTime();
//        end.withChronology(chrono);
//        end.withMillis(((Double) queriedTime.getEnd2()).longValue());
        Query query = session.createQuery("SELECT c FROM Contents c WHERE c.datemillesimevaleur1 > :start AND c.datemillesimevaleur1 < :end ");
        query.setParameter("start", queriedTime.getDtStart1().getYear());
        query.setParameter("end", queriedTime.getDtEnd().getYear());
        List<Contents> contentList = query.list();
        
        return contentList;
        
        
    }
    
}
