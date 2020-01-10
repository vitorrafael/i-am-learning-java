package com.vitorrafael.javamarathon.oop.staticmodifier.classes;

public class Car {

    private String name;
    private double maxSpeed;

    // Static attributes belong to the object, all instances have the same value
    // Static + Access modifier or Access modifier + Static
    private static double limitSpeed = 240;

    public Car(String name, double maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public Car() {

    }

    public void print() {
        System.out.println("---------------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Maximum speed: " + this.maxSpeed);
        System.out.println("Limit speed: " + this.limitSpeed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // Static Methods belong to the class
    // It is not allowed to access instance attributes within static methods
    public static double getLimitSpeed() {
        return limitSpeed;
    }

    public static void setLimitSpeed(double limitSpeed) {
        Car.limitSpeed = limitSpeed;
    }

}
