package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.classes.Car;

public class CarTest {

    public static void main(String[] args) {
        Car car = new Car();

        // To initialize the instace variables => referenceVar.attribute = value;
        car.model = "Porsche";
        car.plate = "h3110";
        car.maximumSpeed = 270.3f;

        System.out.println(car.model);
        System.out.println(car.plate);
        System.out.println(car.maximumSpeed);

    }
}
