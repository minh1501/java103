package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnector {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/PolyOE";
        String user = "root";
        String password = "15012007";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database!");

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}