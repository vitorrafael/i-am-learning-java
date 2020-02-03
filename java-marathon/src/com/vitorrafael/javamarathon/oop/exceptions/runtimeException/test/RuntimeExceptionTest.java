package com.vitorrafael.javamarathon.oop.exceptions.runtimeException.test;

public class RuntimeExceptionTest {

    // A 'Checked' exception needs to be treated
    // An 'Unchecked' exception don't need to be treated, most of
    // it is beyond the developer responsibilities.

    // All exceptions that inherit from the 'RuntimeException' are unchecked

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        // It's not possible to divide by 0, throws ArithmeticException
        if(b != 0) {
            int c = a/b;
            System.out.println(c);
        }

        // Since "o" points to null, there is no object to call the method
        Object o = null;
        System.out.println(o.toString());
    }
}
