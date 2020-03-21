package com.vitorrafael.javamarathon.JDBC;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

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

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:postgresql://localhost:5432/car_agency";
        String user = "postgres";
        String password = "docker";

        try {
            // Get the RowSet Object
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

            // Configure the RowSet attributes
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CachedRowSet getCachedRowSetConnection() {
        // By passing relaxAutoCommit=true to the url, no autoCommit exception will be raised
        String url = "jdbc:postgresql://localhost:5432/car_agency";
        String user = "postgres";
        String password = "docker";

        try {
            // Get the CachedRowSet object
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            // Configure the CachedRowSet attributes
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            return cachedRowSet;

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

    public static void close(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn,  Statement stmt) {
        close(conn);
        close(stmt);
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(conn);
        close(stmt);
        close(rs);
    }

    public static void close(JdbcRowSet rowSet) {
        try {
            if(rowSet != null) {
                rowSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
