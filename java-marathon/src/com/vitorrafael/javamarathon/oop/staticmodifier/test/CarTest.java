package com.vitorrafael.javamarathon.oop.staticmodifier.test;

import com.vitorrafael.javamarathon.oop.staticmodifier.classes.Car;

public class CarTest {

    public static void main(String[] args) {
        Car c1 = new Car("BMW", 280);
        Car c2 = new Car("Audi", 275);
        Car c3 = new Car("Mercedes", 290);

        c1.print();
        c2.print();
        c3.print();

        // Modifying the value, changes it in all object instances
        // It's recommended to change the value accessing the class instead of a instance
        Car.setLimitSpeed(300);

        c1.print();
        c2.print();
        c3.print();
    }
}
