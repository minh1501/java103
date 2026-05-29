package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    static String url = "jdbc:mysql://localhost:3306/OnlineEntertainment";
    static String user = "root";
    static String password = "15012007";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}