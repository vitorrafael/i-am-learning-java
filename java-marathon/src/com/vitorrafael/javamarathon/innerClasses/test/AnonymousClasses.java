package com.vitorrafael.javamarathon.innerClasses.test;

import java.util.*;
import com.vitorrafael.javamarathon.generics.classes.Car;

class Animal {
    public void walk() {
        System.out.println("The animal is walking!");
    }
}

public class AnonymousClasses {
    // An anonymous class exists in certain point and will end after finishing its purporse

    public static void main(String[] args) {
        Animal animal = new Animal(){
            public void walk() {
                System.out.println("The animal is walking anonymously!");
            }
        };

        animal.walk();

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW"));
        carList.add(new Car("Mercedes"));
        carList.add(new Car("Audi"));
        // Here we are creating a anonymous class that implements an interface
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // It is also possible to implement with lambda
        Collections.sort(carList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(carList);
    }
}
