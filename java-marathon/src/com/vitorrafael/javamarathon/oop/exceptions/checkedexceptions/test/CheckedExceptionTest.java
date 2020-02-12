package com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.test;

import java.io.*;

public class CheckedExceptionTest {

    // Checked Exceptions must be treated
    // 'throws' keyword says that method x might throw an exception y

    public static void main(String[] args) {
        createFile();
        openFile();
    }

    public static void createFile() {
        File file = new File("test.txt");
        try {
            file.createNewFile(); // Must treat exception
            System.out.println("File created");
        } catch (IOException e) {
            // Catch the exception and store it in a reference variable 'e'
            // The 'try' block must have the possibility to throw the exception

            e.printStackTrace(); // Print everything until the error was thrown
        }
    }

    public static void openFile() {
        File file = new File("test.txt");
        try {
            file.createNewFile(); // Must treat exception
            System.out.println("Opening the file...");
            System.out.println("Reading the file...");
            throw new Exception();
            // System.out.println("Writing on the file...");
        } catch (Exception e) {
            e.printStackTrace(); // Print everything until the error was thrown
        } finally {
            // This block is executed after catching the exception or after
            // the try, the 'try' block must be followed by either 'catch'
            // 'finally' or both.
            // It will be always executed even if there is 'return' before
            System.out.println("Closing the file");
        }
    }
}
