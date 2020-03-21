package com.vitorrafael.javamarathon.JDBC.db;

import com.vitorrafael.javamarathon.JDBC.ConnectionFactory;
import com.vitorrafael.javamarathon.JDBC.classes.Customer;
import com.vitorrafael.javamarathon.JDBC.classes.RowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTableGeneralCommands {
    public static void save(Customer customer) {
        String sql = String.format("INSERT INTO customer(cpf, name) VALUES ('%s', '%s')", customer.getCpf(), customer.getName());
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

    public static void delete(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to delete the registry.");
            return;
        }
        String sql = String.format("DELETE FROM customer WHERE id=%d", customer.getId());
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

    public static void update(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }
        String sql = String.format("UPDATE  customer SET cpf='%s', name='%s' WHERE id=%d", customer.getCpf(), customer.getName(), customer.getId());
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

    public static List<Customer> selectAll() {
        String sql = "SELECT id, cpf, name FROM custome";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // ResultSet contains the rows that the executed query returned
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                // It's possible to use the index (Starting from 1) or the column name
                // Never mix index with name, chose and follow one convention
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, stmt);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Customer> selectAllByName(String name) {
        String sql = "SELECT id, cpf, name FROM  customer WHERE name LIKE '%" + name + "%'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // ResultSet contains the rows that the executed query returned
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                // It's possible to use the index (Starting from 1) or the column name
                // Never mix index with name, chose and follow one convention
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, stmt);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetadata() {
        String sql = "SELECT id, cpf, name FROM customer";
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
            for (int i = 1; i <= columnQuantity; i++) {
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
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                // This Type allows only to go top-bottom
                System.out.println("Supports TYPE_FORWARD_ONLY");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    // The ResultSet can be updated
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    // The ResultSet can only be read
                    System.out.println("Also supports READ_ONLY");
                }
            }
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                // This Type allows you to move the cursor forward or backward or to a specific modification,
                // and the changes in the database won't be reflected in the ResultSet
                System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Also supports READ_ONLY");
                }
            }
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                // This type work just like the TYPE_SCROLL_INSENSITIVE, but any changes in the database will
                // be reflected
                System.out.println("Supports TYPE_SCROLL_SENSITIVE");
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Also supports CONCUR_UPDATATABLE");
                }
                if (dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Also supports READ_ONLY");
                }
            }
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void typeScrolling() {
        String sql = "SELECT id, cpf, name FROM customer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create a statement with the defined scroll type and concurrence type
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(sql);

            // Moves the cursor to the last line
            resultSet.last();
            System.out.println(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Moves the cursor back to the first line
            resultSet.first();
            System.out.println(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Moves the cursor to the line passed as parameter
            resultSet.absolute(4);
            System.out.println(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            System.out.println("Row number: " + resultSet.getRow());

            // Moves the cursor based on the line that you are
            resultSet.relative(-1); // Increase or decrease the row according to the number passed
            System.out.println(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
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
            while (resultSet.previous()) {
                System.out.println(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }

            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWithResultSet() {
        String sql = "SELECT id, cpf, name FROM customer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(sql);
            DatabaseMetaData dbMetadata = conn.getMetaData();
            System.out.println("Detects updated: " + dbMetadata.updatesAreDetected(resultSet.TYPE_SCROLL_INSENSITIVE));

            while (resultSet.next()) {
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
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertWithResultSet() {
        String sql = "SELECT id, cpf, name FROM customer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(sql);

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
        String sql = "SELECT id, cpf, name FROM customer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(sql);

            // Go to the determined row
            resultSet.absolute(8);

            // Delete the row
            resultSet.deleteRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> selectAllByNameWithPreparedStatement(String name) {
        // PreparedStatement is a subclass os Statement that makes it harder to do a SQL Injection

        // Use the wildcard "?" where the variable would go
        // The variable that will be placed on the wildcard must have the required %
        String sql = "SELECT id, cpf, name FROM customer WHERE name LIKE ?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Sets the first parameter to be the name
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customerList = new ArrayList<>();

            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, preparedStatement);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateWithPreparedStatement(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }
        String sql = "UPDATE  customer  SET cpf=?, name=? WHERE id=?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCpf());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getId());

            preparedStatement.executeUpdate();

            System.out.println("Registry updated.");
            ConnectionFactory.close(conn, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> selectAllByNameWithStoredProcedures(String name) {
        // When a Stored Procedure returns a Table, prepareStatement is used

        // The wildcard character (?) goes within the function call
        String sql = "SELECT * FROM  SP_getCustomersByName( ? )";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);

            ResultSet resultSet = pstmt.executeQuery();
            List<Customer> customerList = new ArrayList<>();

            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name").strip()));
            }
            ConnectionFactory.close(conn, pstmt);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String selectNameByIdWithCallableStatement(int id) {
        // Callable Statements are used to call Stored Procedures that return something

        // The wildcard character (?) goes within the function call
        String sql = "{ ? = CALL SP_getNameById( ? )}";

        Connection conn = ConnectionFactory.getConnection();

        try {
            CallableStatement callableStatement = conn.prepareCall(sql);

            // Set the OUTPUT of the callable statement
            callableStatement.registerOutParameter(1, Types.VARCHAR);

            // Set the function parameter
            callableStatement.setInt(2, id);

            // Execute the callableStatement
            callableStatement.execute();

            // Collects the result from the callable statement
            String name = callableStatement.getString(1);

            ConnectionFactory.close(conn, callableStatement);

            return name;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Customer> selectAllByNameWithRowSetConnection(String name) {
        String sql = "SELECT id, cpf, name FROM customer WHERE name LIKE ?";
        // A RowSet keeps connected to the database
        // It is not possible to use Insert, Update or Delete with RowSet
        // Get the rowSet
        JdbcRowSet rowSet = ConnectionFactory.getRowSetConnection();
        rowSet.addRowSetListener(new RowSetListener());
        try {

            // Set the command to the SQL
            rowSet.setCommand(sql);

            rowSet.setString(1, name);

            // Execute the command
            rowSet.execute();

            List<Customer> customerList = new ArrayList<>();

            // Iterate just like in a preparedStatement
            while (rowSet.next()) {
                customerList.add(new Customer(rowSet.getInt("id"), rowSet.getString("cpf"), rowSet.getString("name").strip()));
            }

            ConnectionFactory.close(rowSet);
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateWithRowSet(Customer customer) {
        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }

        // To Update with the RowSet, it is needed to get the row and then update
        String sql = "SELECT * FROM  customer  WHERE id=?";
        JdbcRowSet rowSet = ConnectionFactory.getRowSetConnection();
        rowSet.addRowSetListener(new RowSetListener());
        try {
            rowSet.setCommand(sql);
            rowSet.setInt(1, customer.getId());

            rowSet.execute();

            // Goes to the first position
            rowSet.next();
            rowSet.updateString("name", customer.getName());
            rowSet.updateString("cpf", customer.getCpf());

            // Update the entire row
            rowSet.updateRow();

            System.out.println("Registry updated.");
            ConnectionFactory.close(rowSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWithCachedRowSet(Customer customer) {
        // NOT WORKING INVESTIGATE FURTHER

        if (customer == null || customer.getId() == null) {
            System.out.println("Impossible to  update the registry.");
            return;
        }

        // To Update with the CachedRowSet, it is needed to get the row and then update
        String sql = "SELECT * FROM  customer  WHERE id=?";
        CachedRowSet cachedRowSet = ConnectionFactory.getCachedRowSetConnection();
        cachedRowSet.addRowSetListener(new RowSetListener());

        // In order to deactivate the autoCommit, it's necessary to have a Connection
        Connection conn = ConnectionFactory.getConnection();
        try {
            cachedRowSet.setCommand(sql);
            cachedRowSet.setInt(1, customer.getId());

            cachedRowSet.execute(conn);

            // Set autoCommit to false
            conn.setAutoCommit(false);

            // Goes to the first position
            cachedRowSet.next();

            cachedRowSet.updateString("name", customer.getName());
            cachedRowSet.updateString("cpf", customer.getCpf());

            // Update the entire row
            cachedRowSet.updateRow();

            // When using CachedRowSet it is necessary to commit the changes
            cachedRowSet.acceptChanges(conn);

            System.out.println("Registry updated.");
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveWithTransactions(List<Customer> customers) {
        // Transactions contains one or more SQL statements that in order to be effectively applied
        // must all be committed or all rolled back

        List<String> transactions = new ArrayList<>();

        for(Customer customer : customers) {
            String sql = String.format("INSERT INTO customer(cpf, name) VALUES ('%s', '%s')", customer.getCpf(), customer.getName());
            transactions.add(sql);
        }
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Set autoCommit to false
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();

            // Executes the transactions
            for(String sql : transactions) {
                stmt.executeUpdate(sql);
            }

            // Commit the changes
            conn.commit();

            // If you're going to continue using the connection set the autoCommit to false
            System.out.println("Registry created.");
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveWithTransactionsTestRollback(List<Customer> customers) {
        // Transactions contains one or more SQL statements that in order to be effectively applied
        // must all be committed or all rolled back

        List<String> transactions = new ArrayList<>();

        for(Customer customer : customers) {
            String sql = String.format("INSERT INTO customer(cpf, name) VALUES ('%s', '%s')", customer.getCpf(), customer.getName());
            transactions.add(sql);
        }
        Connection conn = ConnectionFactory.getConnection();
        // Savepoint is used to keep track of the transaction even if a exception is thrown
        Savepoint savepoint = null;
        try {
            // Set autoCommit to false
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();

            // Executes the transactions
            for(String sql : transactions) {
                stmt.executeUpdate(sql);
                savepoint = conn.setSavepoint();
                // Throw a SQLException for learning purpose
                if(true) throw new SQLException();
            }

            // Commit the changes
            conn.commit();

            // If you're going to continue using the connection set the autoCommit to false
            System.out.println("Registry created.");
            ConnectionFactory.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                // Will rollback the state of the database before the transaction
                // Or, if passed as an argument, will rollback to the savepoint
                conn.rollback(savepoint);

                // Commit the changes made up to the savepoint
                conn.commit();
                System.out.println("Rollbacking");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

