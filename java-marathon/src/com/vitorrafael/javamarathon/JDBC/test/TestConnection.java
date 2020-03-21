package com.vitorrafael.javamarathon.JDBC.test;

import com.vitorrafael.javamarathon.JDBC.classes.Customer;
import com.vitorrafael.javamarathon.JDBC.db.CustomerTableGeneralCommands;

import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
       saveWithTransactionsTestRollback();
    }

    public static void insert() {
        Customer customer = new Customer();
        CustomerTableGeneralCommands.save(customer);
    }

    public static void delete() {
        Customer customer = new Customer();
        customer.setId(1);
        CustomerTableGeneralCommands.delete(customer);
    }

    public static void update() {
        Customer customer = new Customer();
        CustomerTableGeneralCommands.update(customer);
    }

    public static List<Customer> selectAll() {
        return CustomerTableGeneralCommands.selectAll();
    }

    public static List<Customer> selectAllByName(String name) {
        return CustomerTableGeneralCommands.selectAllByName(name);
    }

    public static List<Customer> selectAllByNameWithPreparedStatement(String name) {
        return CustomerTableGeneralCommands.selectAllByNameWithPreparedStatement(name);
    }

    public static void updateWithPreparedStatement() {
        Customer customer = new Customer(3, "999.999.999-99", "Perry Folks");
        CustomerTableGeneralCommands.updateWithPreparedStatement(customer);
    }

    public static List<Customer> selectAllByNameWithStoredProcedure(String name) {
        return CustomerTableGeneralCommands.selectAllByNameWithStoredProcedures(name);
    }

    public  static String selectNameByIdWithCallableStatementAndStoredProcedure(int id) {
        return CustomerTableGeneralCommands.selectNameByIdWithCallableStatement(id);
    }

    public static List<Customer> selectAllByNameWithRowSet(String name) {
        return CustomerTableGeneralCommands.selectAllByNameWithRowSetConnection(name);
    }

    public static void updateWithRowSet() {
        Customer customer = new Customer(7, "101.111.999-99", "Angela Moss");
        CustomerTableGeneralCommands.updateWithRowSet(customer);
    }

    public static void updateWithCachedRowSet() {
        Customer customer = new Customer(3, "878.686.979-27", "Roberta Campos");
        CustomerTableGeneralCommands.updateWithCachedRowSet(customer);
    }

    public static void saveWithTransactions() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("598.688.708-98", "Maria da Silva"));
        customers.add(new Customer("322.862.722-42", "Rodrigo Martins"));
        customers.add(new Customer("142.732.987-47", "Fabrício Rodrigues"));
        CustomerTableGeneralCommands.saveWithTransactions(customers);
    }

    public static void saveWithTransactionsTestRollback() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("688.708.508-98", "George Fausto"));
        customers.add(new Customer("862.722.862-43", "Barbara Gloria"));
        customers.add(new Customer("732.987.142-46", "Julia Garcia"));
        CustomerTableGeneralCommands.saveWithTransactionsTestRollback(customers);
    }
}


