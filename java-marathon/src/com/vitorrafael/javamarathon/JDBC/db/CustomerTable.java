package com.vitorrafael.javamarathon.JDBC.db;

import com.vitorrafael.javamarathon.JDBC.ConnectionFactory;
import com.vitorrafael.javamarathon.JDBC.classes.Customer;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  CustomerTable {

    public static void save(Customer customer) {
        String sql = "INSERT INTO customer(cpf, name) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))  {

            stmt.setString(1, customer.getCpf());
            stmt.setString(2, customer.getName());
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to delete the registry.");
            return;
        }

        String sql = "DELETE FROM customer WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customer.getId());
            stmt.executeUpdate();
            System.out.println("Registry deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }

        String sql = "UPDATE  customer  SET cpf=?, name=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getCpf());
            stmt.setString(2, customer.getName());
            stmt.setInt(3, customer.getId());

            stmt.executeUpdate();
            System.out.println("Registry updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> selectAll() {
        String sql = "SELECT id, cpf, name FROM customer";
        try  (Connection conn = ConnectionFactory.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet resultSet = stmt.executeQuery()) {

            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Customer> selectAllByName(String name) {
        String sql = "SELECT id, cpf, name FROM customer  WHERE name LIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");

            ResultSet resultSet = stmt.executeQuery();
            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(resultSet);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Customer selectById(int id) {
        String sql = "SELECT id, cpf, name FROM Customer WHERE id=?";
        Customer customer = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                customer = new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name"));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  customer;
    }
}
