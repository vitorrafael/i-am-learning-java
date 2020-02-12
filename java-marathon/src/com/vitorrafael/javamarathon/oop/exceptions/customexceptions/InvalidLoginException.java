package com.vitorrafael.javamarathon.oop.exceptions.customexceptions;

public class InvalidLoginException extends Exception {

    public InvalidLoginException() {
        // It is a convention to finish the class name with Exception
        // Exceptions classes must not catch other exceptions
        super("Invalid User or Password");
    }
}
