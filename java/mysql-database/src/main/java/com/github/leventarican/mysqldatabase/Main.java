package com.github.leventarican.mysqldatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Levent
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&useSSL=false");
            Connection conn = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/mysql?user=root");
            ResultSet result = conn.createStatement().executeQuery("select * from user");
            while (result.next()) {
                System.out.println(result.getString("user"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
