package com.vitorrafael.javamarathon.oop.exceptions.customexceptions.test;

import com.vitorrafael.javamarathon.oop.exceptions.customexceptions.InvalidLoginException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            login();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
    }

    private static void login() throws InvalidLoginException {
        String user = "Goku";
        String password = "666";

        String userInput = "Goku";
        String passwordInput = "111";

        if((user.equals(userInput) || (password.equals(passwordInput)))) {
            throw new InvalidLoginException();
        } else {
            System.out.println("Login in!");
        }
    }
}
