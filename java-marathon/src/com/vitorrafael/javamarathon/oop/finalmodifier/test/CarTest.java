package com.vitorrafael.javamarathon.oop.finalmodifier.test;

import com.vitorrafael.javamarathon.oop.finalmodifier.classes.Buyer;
import com.vitorrafael.javamarathon.oop.finalmodifier.classes.Car;

public class CarTest {

    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car.getBuyer());
        car.getBuyer().setName("Rafael");
        System.out.println(car.getBuyer());

    }
}
