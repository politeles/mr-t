package es.ugr.decsai.excel2sql;

import es.ugr.decsai.excel2sql.sql.SqlDatatypes;
import es.ugr.decsai.excel2sql.sql.SqlFormat;
import es.ugr.decsai.excel2sql.sql.sqlite.SqLiteTypeRender;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.type.Type;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //  if(args.length >0){
        //String filename = args[0];
        String path = "E:\\Users\\Jose\\Documents\\sources\\mr-t\\develop\\excel2sql\\documents\\";
        String filename = "Output_Test.xlsx";
        System.out.println("Starting with argument: " + filename);

        try {
            ExcelReader er = new ExcelReader(path+filename);
            System.out.println("File read");
            List<String> fieldList = er.getFieldList();
            System.out.println("Computing field list done");
            List<SqlDatatypes> heuristicHibernateTypes = er.heuristicHibernateTypes();
            System.out.println("Computing types done");

            SqlFormat sqlf = new SqlFormat(new SqLiteTypeRender());
            String createSentece = sqlf.createSentece("Contents", fieldList, heuristicHibernateTypes);
            System.out.println(createSentece);
            String insertSentence = sqlf.insertSentence("Contents",er.getRowContents(1) , heuristicHibernateTypes);
            String deleteSentence = "DROP TABLE Contents";
            System.out.println(insertSentence);
            
            //try to connect to sqlitedb:
            String driverName = "org.sqlite.JDBC";
            Class.forName(driverName);
            
            String databaseName = "history.db";
            String connectionString = "jdbc:sqlite:" + path+ databaseName;
            Connection conn = DriverManager.getConnection(connectionString);
           // Statement stm;
            try{
               Statement stm = conn.createStatement();
               try{
                   stm.executeUpdate(deleteSentence);
                   stm.executeUpdate(createSentece);
                  // stm.executeUpdate(insertSentence);
                   for(int i=1;i<er.getRows();i++){
                       sqlf.insertDatabase("Contents", er.getRowContents(i), heuristicHibernateTypes, fieldList, conn);
                       System.out.println("Inserting row"+i+"...");
//                    sqlf.insertDatabase("Contents", er.getRowContents(1523), heuristicHibernateTypes, fieldList, conn);
                   }
                   
               }
            catch(Exception ex){
                ex.printStackTrace();
                
            }finally{
                try{stm.close();}catch(Exception ignore){}
            }
            }catch(Exception ex){
                   ex.printStackTrace();
               }finally{
                try{conn.close();}catch(Exception ignore){ignore.printStackTrace();}
            }
            
            
            //            for(int i = 0; i<fieldList.size();i++){
            //                System.out.println(fieldList.get(i)+ " type :"+heuristicHibernateTypes.get(i));
            //
            //            }


        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

//        }else{
//            System.err.println("Wrong call");
//        }
    }
}
