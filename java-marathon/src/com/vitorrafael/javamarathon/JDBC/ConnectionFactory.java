package com.vitorrafael.javamarathon.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    // Here we are building a connection with the database

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/car_agency";
        String user = "postgres";
        String password = "docker";

        try {
            // Try to create an connection with the information passed as parameters
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void close(Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn,  Statement stmt) {
        close(conn);
        close(stmt);
    }
}
