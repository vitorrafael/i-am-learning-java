package com.vitorrafael.javamarathon.oop.exceptions.multicatch.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiCatchExceptionTest {
    public static void main(String[] args) {
        try {
            mightThrowException();
        } catch (SQLException | IOException e) {
            // If "catch (Exception e)" is used, you will only
            // catch the exceptions that might be thrown by the method
            // Use pipes to separate the multi catch after Java 7
            // Subclasses and superclasses cannot be at the same catch
        }
    }

    private static void mightThrowException() throws SQLException, FileNotFoundException {

    }
}
