package com.vitorrafael.javamarathon.arrays;

public class Arrays1 {

    public static void main(String[] args) {

        // Creates an array of integers with size 3
        // When declared, the default value changes accordingly to the array type
        // Default Values:
        //   byte, short, int, long, double => 0;
        //   char => '/u0000';
        //   boolean => false;
        //   reference => null;
        int[] ages = new int[3]; // An array is a reference type -> Object

        // Allocates the values to the space in the array
        ages[0] = 20;
        ages[1] = 15;
        ages[2] = 30;

        System.out.println("Age 1: " + ages[0]);
        System.out.println("Age 2: " + ages[1]);
        System.out.println("Age 3: " + ages[2]);

        // It's not possible to change the array's size on runtime
        String[] names = new String[4];
        names[0] = "Vitor";
        names[1] = "Gabriela";
        names[2] = "Eduardo";
        names[3] = "Alexia";

        System.out.println("Names has a length of " + names.length);
        for(int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ": " + names[i]);
        }
    }
}
