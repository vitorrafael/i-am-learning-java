package com.vitorrafael.javamarathon.oop.wrapperclasses.test;

public class WrappersTest {

    public static void main(String[] args) {

        byte bytePrimitive = 1;
        short shortPrimitive = 3;
        int intPrimitive = 100000;
        long longPrimitive = 1000000000;

        float floatPrimitive = 3.1415f;
        double doublePrimitive = 3.14151923;

        char charPrimitive = 'a';

        boolean booleanPrimitive = true;

        // Wrapper classes are basically named with the first letter capitalized
        // With the exception of Integer and Character
        Byte byteWrapper = 1;
        Short shortWrapper = 3;
        Integer intWrapper = 100000;
        Long longWrapper = 1000000000l; // Add l to the final
        Float floatWrapper = 3.1415f;
        Double doubleWrapper = 3.1415;
        Character charWrapper = 'a';
        Boolean booleanWrapper = false;

        // All wrappers, with the exception of Characters, can take Strings
        Boolean convTest = new Boolean("True");
        System.out.println(convTest);

        // The wrappers contain parsers
        Float f = Float.parseFloat("3.1415f");
        System.out.println(f);

        // Auto-boxing -> Get a primitive type and store it in a wrapper
        int example = 3;
        Integer exampleWrapper = example;

        // Unboxing -> Get a wrapper and store it in a primitive type
        int example2 = exampleWrapper;
    }

}