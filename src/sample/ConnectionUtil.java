package sample;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    Connection con = null;

    public static Connection getConnection(){

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://ricky.heliohost.org/nmasodia_print",
                    "nmasodia_aditi", "00000");

            return con;



            } catch (Exception ex){

            System.err.println("ConnectionUtil : "+ex.getMessage());
            return  null;

        }






    }



}
