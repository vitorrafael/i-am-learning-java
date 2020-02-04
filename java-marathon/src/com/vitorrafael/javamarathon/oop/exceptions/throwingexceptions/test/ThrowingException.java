package com.vitorrafael.javamarathon.oop.exceptions.throwingexceptions.test;

import java.io.*;

public class ThrowingException {

    public static void main(String[] args) {
        try {
            division(10, 0);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void division(int num1, int num2) {
        if(num2 == 0) {
            // Throws an exception
            // Runtime exceptions don't need to be declared on the method
            throw new IllegalArgumentException("Parameter 'num2' cannot be 0.");
        }

        int result = num1/num2;

        System.out.println(result);
    }

    // This method might throw an IOException
    private static void createFile() throws IOException {
        File file = new File("test.txt");
        System.out.println("File created: " + file.createNewFile());
    }
}
