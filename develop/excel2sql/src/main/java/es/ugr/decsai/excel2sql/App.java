package es.ugr.decsai.excel2sql;

import es.ugr.decsai.excel2sql.sql.SqlDatatypes;
import es.ugr.decsai.excel2sql.sql.SqlFormat;
import es.ugr.decsai.excel2sql.sql.sqlite.SqLiteTypeRender;
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
        String filename = "E:\\Users\\Jose\\Documents\\sources\\mr-t\\develop\\excel2sql\\documents\\Output_Test.xlsx";
        System.out.println("Starting with argument: " + filename);

        try {
            ExcelReader er = new ExcelReader(filename);
            System.out.println("File read");
            List<String> fieldList = er.getFieldList();
            System.out.println("Computing field list done");
            List<SqlDatatypes> heuristicHibernateTypes = er.heuristicHibernateTypes();
            System.out.println("Computing types done");

            SqlFormat sqlf = new SqlFormat(new SqLiteTypeRender());
            String createSentece = sqlf.createSentece("Contents", fieldList, heuristicHibernateTypes);
            System.out.println(createSentece);
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
