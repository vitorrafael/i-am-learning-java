package com.vitorrafael.javamarathon.JDBC.db;

import com.vitorrafael.javamarathon.JDBC.ConnectionFactory;
import com.vitorrafael.javamarathon.JDBC.classes.Car;
import com.vitorrafael.javamarathon.JDBC.classes.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  CarTable {

    public static void save(Car car) {
        String sql = "INSERT INTO car(plate, name, customer_id) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))  {

            stmt.setString(1, car.getPlate());
            stmt.setString(2, car.getName());
            stmt.setInt(3, car.getCustomer().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Car car) {
        if (car == null || car.getId() == null) {
            System.out.println("Impossible to delete the registry.");
            return;
        }

        String sql = "DELETE FROM car WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, car.getId());
            stmt.executeUpdate();
            System.out.println("Registry deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Car car) {
        if (car == null || car.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }

        String sql = "UPDATE  car  SET plate=?, name=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, car.getPlate());
            stmt.setString(2, car.getName());
            stmt.setInt(3, car.getId());

            stmt.executeUpdate();
            System.out.println("Registry updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> selectAll() {
        String sql = "SELECT id, plate, name, customer_id FROM car";
        try  (Connection conn = ConnectionFactory.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet resultSet = stmt.executeQuery()) {

            List<Car> carList = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = CustomerTable.selectById(resultSet.getInt("customer_id"));
                carList.add(new Car(resultSet.getInt("id"), resultSet.getString("plate"), resultSet.getString("name").strip(), customer));
            }
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Car> selectAllByName(String name) {
        String sql = "SELECT id, plate, name, customer_id FROM car  WHERE name LIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");

            ResultSet resultSet = stmt.executeQuery();
            List<Car> carList = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = CustomerTable.selectById(resultSet.getInt("customer_id"));
                carList.add(new Car(resultSet.getInt("id"), resultSet.getString("plate"), resultSet.getString("name").strip(), customer));
            }
            ConnectionFactory.close(resultSet);
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
