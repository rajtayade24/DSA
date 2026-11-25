package com.java.dsa.college;

import java.sql.*;

public class Exp7 {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "your_password";

            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            System.out.println("Database connected successfully!");

            // Close connection
            con.close();
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
}