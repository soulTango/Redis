package aa;

import java.sql.*;

public class Mysql {

         public Connection conn;

         {

                 try {

                          Class.forName("com.mysql.jdbc.Driver");

                          conn=DriverManager.getConnection("jdbc:mysql://localhost/hmms","root","99.99");

                 } catch (ClassNotFoundException e) {

                          e.printStackTrace();

                 } catch (SQLException e) {

                          e.printStackTrace();

                 }

         }

 

}