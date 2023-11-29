package atm2;

import java.sql.*;


public class DatabaseConnection {

    static Connection conn;

    public static  Connection dbConnection() {

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm", "root", "Andile@2001");
            return conn;
        } catch (Exception e) {
            System.out.println("Problem when connecting to db");
        }


        return conn;


    }

}

