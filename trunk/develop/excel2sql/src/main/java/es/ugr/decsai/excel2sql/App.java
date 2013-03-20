package es.ugr.decsai.excel2sql;

import es.ugr.decsai.excel2sql.sql.SqlDatatypes;
import es.ugr.decsai.excel2sql.sql.SqlFormat;
import es.ugr.decsai.excel2sql.sql.hsqldb.HSqlDBTypeRender;
import es.ugr.decsai.excel2sql.sql.sqlite.SqLiteTypeRender;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base class application
 *
 */
public class App {

    private static final String PROPERTIES_FILENAME = "configuration.properties";
    private static final String PATH = "path";
    private static final String INFILE = "input";
    private static final String OUTFILE = "output";
    private static final String CREATE = "create";
    private static final String EXPORT = "export_data";
    private static final String DRIVER = "driver_name";
    private static final String CONNECTION = "connection_string";
    private static final String MAX = "max_items";

    /* 
     * 
     * create=true
     # ¿export the database?
     export_data=true
     */
    public static void main(String[] args) {

        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream(PROPERTIES_FILENAME));
            String path = p.getProperty(PATH);
            String filename = p.getProperty(INFILE);
            String outputFile = p.getProperty(OUTFILE);

            String driver = p.getProperty(DRIVER);
            String url = p.getProperty(CONNECTION);

            boolean create = Boolean.valueOf(p.getProperty(CREATE));
            boolean export = Boolean.valueOf(p.getProperty(EXPORT));
            
            int maxItems = Integer.valueOf(p.getProperty(MAX));


            System.out.println("Starting with argument: " + filename);
            ExcelReader er = new ExcelReader(path + filename);
            System.out.println("File read");
            List<String> fieldList = er.getFieldList();
            System.out.println("Computing field list done");
            List<SqlDatatypes> heuristicHibernateTypes = er.heuristicHibernateTypes();
            System.out.println("Computing types done");

            SqlFormat sqlf = new SqlFormat(new HSqlDBTypeRender());
            String createSentece = sqlf.createSentece("Contents", fieldList, heuristicHibernateTypes);
            System.out.println(createSentece);
            String insertSentence = sqlf.insertSentence("Contents", er.getRowContents(1), heuristicHibernateTypes);
            String deleteSentence = "DROP TABLE Contents IF EXISTS";
            System.out.println(insertSentence);

            //try to connect to sqlitedb:

            Class.forName(driver);
            

            String connectionString = url;
            Connection conn = DriverManager.getConnection(connectionString);
            System.out.println("Connected to database");
            // Statement stm;
            try {
                Statement stm = conn.createStatement();
                try {
                    if (create) {
                        
                        stm.executeUpdate(deleteSentence);
                        stm.executeUpdate(createSentece);
                        
                        conn.commit();
                        System.out.println("Create sentence sent");
                    }
                    // stm.executeUpdate(insertSentence);
                    if (export) {
                        int end = er.getRows();
                        if(maxItems != 0){
                            end = maxItems+1;
                        }
                        for (int i = 1; i < end; i++) {
                            sqlf.insertDatabase("Contents", er.getRowContents(i), heuristicHibernateTypes, fieldList, conn);
                            System.out.println("Inserting row" + i + "...");
//                    sqlf.insertDatabase("Contents", er.getRowContents(1523), heuristicHibernateTypes, fieldList, conn);
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();

                } finally {
                    try {
                        stm.close();
                    } catch (Exception ignore) {
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }




         
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


        //  if(args.length >0){
        //String filename = args[0];
//        String path = "E:\\Users\\Jose\\Documents\\sources\\mr-t\\develop\\excel2sql\\documents\\";
//        String filename = "Output_Test.xlsx";


//        try {
//            ExcelReader er = new ExcelReader(path+filename);
//            System.out.println("File read");
//            List<String> fieldList = er.getFieldList();
//            System.out.println("Computing field list done");
//            List<SqlDatatypes> heuristicHibernateTypes = er.heuristicHibernateTypes();
//            System.out.println("Computing types done");
//
//            SqlFormat sqlf = new SqlFormat(new SqLiteTypeRender());
//            String createSentece = sqlf.createSentece("Contents", fieldList, heuristicHibernateTypes);
//            System.out.println(createSentece);
//            String insertSentence = sqlf.insertSentence("Contents",er.getRowContents(1) , heuristicHibernateTypes);
//            String deleteSentence = "DROP TABLE Contents";
//            System.out.println(insertSentence);
//            
//            //try to connect to sqlitedb:
//            String driverName = "org.sqlite.JDBC";
//            Class.forName(driverName);
//            
//            String databaseName = "history.db";
//            String connectionString = "jdbc:sqlite:" + path+ databaseName;
//            Connection conn = DriverManager.getConnection(connectionString);
//           // Statement stm;
//            try{
//               Statement stm = conn.createStatement();
//               try{
//                   stm.executeUpdate(deleteSentence);
//                   stm.executeUpdate(createSentece);
//                  // stm.executeUpdate(insertSentence);
//                   for(int i=1;i<er.getRows();i++){
//                       sqlf.insertDatabase("Contents", er.getRowContents(i), heuristicHibernateTypes, fieldList, conn);
//                       System.out.println("Inserting row"+i+"...");
////                    sqlf.insertDatabase("Contents", er.getRowContents(1523), heuristicHibernateTypes, fieldList, conn);
//                   }
//                   
//               }
//            catch(Exception ex){
//                ex.printStackTrace();
//                
//            }finally{
//                try{stm.close();}catch(Exception ignore){}
//            }
//            }catch(Exception ex){
//                   ex.printStackTrace();
//               }finally{
//                try{conn.close();}catch(Exception ignore){ignore.printStackTrace();}
//            }
//            
//            
//            //            for(int i = 0; i<fieldList.size();i++){
//            //                System.out.println(fieldList.get(i)+ " type :"+heuristicHibernateTypes.get(i));
//            //
//            //            }
//
//
//        } catch (Exception ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
////        }else{
////            System.err.println("Wrong call");
////        }
    }
}
