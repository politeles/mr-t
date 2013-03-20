/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.historydb.util;

import es.ugr.decsai.historydb.model.Contents;
import es.ugr.decsai.jpons.uticalculator.Uti;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class ContentsUtil {

    public static Uti buildUtiFromContent(Contents c) {
        if (c == null) {
            return null;
        }
        List<DateTime> dateTimeFromContents = getDateTimeFromContents(c);
        DateTime min, max;
        min = max = dateTimeFromContents.get(0);




        for (DateTime t : dateTimeFromContents) {
            if (min.isAfter(t)) {
                min = t;
            }
            if (max.isBefore(t)) {
                max = t;
            }
        }



        Uti u = new Uti(min.minusSeconds(1000), min, min.plusSeconds(1000), max.minusSeconds(1000), max, max.plusSeconds(1000));

        return u;
    }

    public static List<DateTime> getDateTimeFromContents(Contents c) {
        if (c == null) {
            return null;
        }


        Class<?> clazz = c.getClass();
        Chronology chrono = GJChronology.getInstance();
        List<DateTime> dtList = new ArrayList<DateTime>(15);

        int d1, m1, y1;

        try {
            y1 = c.getDatemillesimevaleur1();
        } catch (NullPointerException ex) {
            y1 = 0;
        }
        try {
            m1 = c.getDatemoisvaleur1();
            if (m1 < 1 || m1 > 12) {
                m1 = 1;
            }
        } catch (NullPointerException ex) {
            m1 = 1;
        }

        try {
            d1 = c.getDatejourvaleur1();
            if (d1 < 1 || d1 > 31) {
                d1 = 1;
            }
        } catch (NullPointerException ex) {
            d1 = 1;
        }

        DateTime dt1 = new DateTime(y1, m1, d1, 0, 0, chrono);
        dtList.add(dt1);
        Class[] params = new Class[0];
//        params[0] = Integer.TYPE;


        for (int i = 1; i < 15; i++) {
            try {
                Method yearm = clazz.getDeclaredMethod("getMixdat1valeur" + i, params);
                Method monthm = clazz.getDeclaredMethod("getMixdat2valeur" + i, params);
                Method daym = clazz.getDeclaredMethod("getMixdat3valeur" + i, params);


//                Field yearf = clazz.getDeclaredField("mixdat1valeur" + i);
//                Field monthf = clazz.getDeclaredField("mixdat2valeur" + i);
//                Field dayf = clazz.getDeclaredField("mixdat3valeur" + i);

                int day, month, year;

                try {
                    year = (Integer) yearm.invoke(c, params);
                } catch (Exception ex) {
                    year = 1;
                }
                try {
                    month = (Integer) monthm.invoke(c, params);
                    if (month < 1 || month > 12) {
                        month = 1;
                    }
                } catch (Exception ex) {
                    month = 1;
                }

                try {
                    day = (Integer) daym.invoke(c, params);
                    if (day < 1 || day > 31) {
                        day = 1;
                    }
                } catch (Exception ex) {
                    day = 1;
                }

                DateTime dt = new DateTime(year, month, day, 0, 0, chrono);

                dtList.add(dt);



            } catch (Exception ex) {
                ex.printStackTrace();
            }




        }
        return dtList;


    }
}
