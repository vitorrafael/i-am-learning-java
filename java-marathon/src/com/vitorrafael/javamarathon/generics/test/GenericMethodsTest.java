package com.vitorrafael.javamarathon.generics.test;

import com.vitorrafael.javamarathon.generics.classes.Car;

import java.util.*;

public class GenericMethodsTest {

    public static void main(String[] args) {
        createArray(new Dog());
        createArray(new Car());
    }

    public static <T> void createArray(T type) {
        // This method is of the type T
        List<T> list = new ArrayList<>();
        list.add(type);
        System.out.println("First method");
    }

    // We can also use extends and super like in the wildcards
    public  static <T extends Animal> void createArray(T type) {
        // Here we only accept Types that inherits from the Animal class
        List<T> list = new ArrayList<>();
        list.add(type);
        System.out.println("Second method");
    }
}
