package com.vitorrafael.javamarathon.JDBC.db;

import com.vitorrafael.javamarathon.JDBC.ConnectionFactory;
import com.vitorrafael.javamarathon.JDBC.classes.Buyer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
