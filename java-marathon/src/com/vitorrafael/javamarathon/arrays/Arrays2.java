package com.vitorrafael.javamarathon.arrays;


public class Arrays2 {

    public static void main(String[] args) {

        // Creating an array with values already initialized
        int[] numbers = {1, 2, 3, 4, 5}; // Length = 5

        // Foreach -> Access each item
        // The variables must be the same type as the array
        for(int element : numbers) {
            System.out.println(element);
        }

        String[] names = {"Vitor", "Eduardo", "Mikhaela", "Gabriela"};

        for(String name : names) {
            System.out.println(name);
        }
    }
}
