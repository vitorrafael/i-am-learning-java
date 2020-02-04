package com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.test;

import java.io.*;

public class CheckedExceptionTest {

    // Checked Exceptions must be treated
    // 'throws' keyword says that method x might throw an exception y

    public static void main(String[] args) {
        createFile();
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
}
