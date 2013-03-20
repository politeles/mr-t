package es.ugr.decsai.historydb;

import es.ugr.decsai.historydb.dao.ContentDao;
import es.ugr.decsai.historydb.model.Contents;
import es.ugr.decsai.jpons.uticalculator.Uti;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();

        //Query query = session.createQuery("FROM Contents c WHERE c.dateMillesimeValeur1 >600 AND c.dateMillesimeValeur1 <700");
//        Query query = session.createQuery("FROM Contents c ");
//        List list = query.list();
//        for(Object o:list){
//            Contents c = (Contents) o;
//            System.out.println("Contents n: "+c.getNumerowauters()+" year: "+c.getDatemillesimevaleur1());
//        }
//        t.commit();
//        session.close();

        ContentDao dao = new ContentDao(session);
        Chronology chrono = GJChronology.getInstance();
        DateTime start = new DateTime(620, 1, 1, 0, 0, chrono);
        DateTime end = new DateTime(710, 1, 1, 0, 0, chrono);

        DateTime start1 = new DateTime(610, 1, 1, 0, 0, chrono);
        DateTime start2 = new DateTime(630, 1, 1, 0, 0, chrono);

        DateTime end1 = new DateTime(700, 1, 1, 0, 0, chrono);
        DateTime end2 = new DateTime(720, 1, 1, 0, 0, chrono);




        Uti queriedTime = new Uti(start1, start, start2, end1, end, end2);
        List<Contents> contentBetweenDates = dao.getContentBetweenDates(queriedTime);
        if(contentBetweenDates!=null){
            for(Contents c:contentBetweenDates){
                System.out.println("Date: "+c.getDatemillesimevaleur1() + " month: "+c.getDatemoisvaleur1()+ " day "+c.getDatejourvaleur1());
            }
        }


    }
}
