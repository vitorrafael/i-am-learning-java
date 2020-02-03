package com.vitorrafael.javamarathon.oop.exceptions.error.test;

public class ErrorTest {

    // An error cannot be treated, hence it stops the execution of the
    // program.

    public static void main(String[] args) {
        stackOverFlowError();
    }

    public static void stackOverFlowError() {
        // When the stack if overflowed, throws the StackOverFlowError
        stackOverFlowError();
    }
}
