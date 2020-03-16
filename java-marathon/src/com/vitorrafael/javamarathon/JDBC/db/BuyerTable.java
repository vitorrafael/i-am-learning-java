package com.vitorrafael.javamarathon.JDBC.db;

import com.vitorrafael.javamarathon.JDBC.ConnectionFactory;
import com.vitorrafael.javamarathon.JDBC.classes.Buyer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerTable {
    public static void save(Buyer buyer) {
        String sql = String.format("INSERT INTO buyer(cpf, name) VALUES ('%s', '%s')", buyer.getCpf(), buyer.getName());
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create an statement and execute an operation
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Registry created.");
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Buyer buyer) {
        if(buyer == null || buyer.getId() == null) {
            System.out.println("Impossible to delete the registry.");
            return;
        }
        String sql = String.format("DELETE FROM buyer WHERE id=%d", buyer.getId());
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create an statement and execute an operation
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Registry deleted.");
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Buyer buyer) {
        if(buyer == null || buyer.getId() == null) {
            System.out.println("Impossible to delete the registry.");
            return;
        }
        String sql = String.format("UPDATE  buyer  SET cpf='%s', name='%s' WHERE id=%d", buyer.getCpf(), buyer.getName(), buyer.getId());
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create an statement and execute an operation
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Registry updated.");
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Buyer> selectAll() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // ResultSet contains the rows that the executed query returned
            Statement stmt = conn.createStatement();
            ResultSet resultSet =  stmt.executeQuery(sql);
            List<Buyer> buyerList = new ArrayList<>();
            while(resultSet.next()) {
                // It's possible to use the index (Starting from 1) or the column name
                // Never mix index with name, chose and follow one convention
                buyerList.add(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, stmt);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Buyer> selectAllByName(String name) {
        String sql = "SELECT id, cpf, name FROM buyer WHERE name LIKE '%" + name + "%'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // ResultSet contains the rows that the executed query returned
            Statement stmt = conn.createStatement();
            ResultSet resultSet =  stmt.executeQuery(sql);
            List<Buyer> buyerList = new ArrayList<>();
            while(resultSet.next()) {
                // It's possible to use the index (Starting from 1) or the column name
                // Never mix index with name, chose and follow one convention
                buyerList.add(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, stmt);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetadata() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            // Retrieves the Metadata from the table
            ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
            resultSet.next();
            int columnQuantity = resultSetMetadata.getColumnCount();
            System.out.println("Number of columns: " + columnQuantity);
            System.out.println("Table name: " + resultSetMetadata.getTableName(1));
            for(int i = 1; i <= columnQuantity; i++) {
                System.out.println("Column name: " + resultSetMetadata.getColumnName(i));
                System.out.println("Column size: " + resultSetMetadata.getColumnDisplaySize(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus() {
        // The ResultSet have 3 types
        Connection conn = ConnectionFactory.getConnection();
        try {
            DatabaseMetaData dbMetadata = conn.getMetaData();
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                // This Type allows only to go top-bottom
                System.out.println("Supports TYPE_FORWARD_ONLY");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    // The ResultSet can be updated
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    // The ResultSet can only be read
                    System.out.println("Also supports READ_ONLY");
                }
            }
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                // This Type allows you to move the cursor forward or backward or to a specific modification,
                // and the changes in the database won't be reflected in the ResultSet
                System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Also supports READ_ONLY");
                }
            }
            if(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                // This type work just like the TYPE_SCROLL_INSENSITIVE, but any changes in the database will
                // be reflected
                System.out.println("Supports TYPE_SCROLL_SENSITIVE");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Also supports READ_ONLY");
                }
            }
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void typeScrolling() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create a statement with the defined scroll type and concurrence type
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet =  stmt.executeQuery(sql);

            // Moves the cursor to the last line
            resultSet.last();
            System.out.println(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
             System.out.println("Row number: " + resultSet.getRow());

             // Moves the cursor back to the first line
            resultSet.first();
            System.out.println(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Moves the cursor to the line passed as parameter
            resultSet.absolute(4);
            System.out.println(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Moves the cursor based on the line that you are
            resultSet.relative(-1); // Increase or decrease the row according to the number passed
            System.out.println(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Verifies the position of the cursor
            System.out.println(resultSet.isFirst());
            System.out.println(resultSet.isLast());
            System.out.println(resultSet.isBeforeFirst());
            System.out.println(resultSet.isAfterLast());

            // Verifies if there is a row previous to the actual one
            System.out.println(resultSet.previous());

            // Iterating backwards
            resultSet.afterLast();
            while(resultSet.previous()) {
                System.out.println(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }

            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWithResultSet() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet =  stmt.executeQuery(sql);
            DatabaseMetaData dbMetadata = conn.getMetaData();
            System.out.println("Detects updated: " + dbMetadata.updatesAreDetected(resultSet.TYPE_SCROLL_INSENSITIVE ));

            while(resultSet.next()) {
                // First we update the data from the columns
                resultSet.updateString("name", resultSet.getString("name").toLowerCase());

                // It is possible to cancel the row updates
                // resultSet.cancelRowUpdates();
                // It must come before the changes are applied in the database

                // Update the database
                resultSet.updateRow();
            }

            // It will be updated because we the result set values were also updated
            // No extra query was made
            resultSet.beforeFirst();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertWithResultSet() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet =  stmt.executeQuery(sql);

            // Go to an determined column
            resultSet.absolute(2);
            String name = resultSet.getString("name");

            // Move to a temporary row
            resultSet.moveToInsertRow();

            System.out.println(name);
            System.out.println(resultSet.getString("name"));

            // Insert the values by updating the insert row
            resultSet.updateString("name", name.toUpperCase());
            resultSet.updateString("cpf", "000.000.000-00");
            resultSet.insertRow();

            // Go to the previous row
            resultSet.moveToCurrentRow();
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getRow());

            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWithResultSet() {
        String sql = "SELECT id, cpf, name FROM buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet =  stmt.executeQuery(sql);

            // Go to the determined row
            resultSet.absolute(8);

            // Delete the row
            resultSet.deleteRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
