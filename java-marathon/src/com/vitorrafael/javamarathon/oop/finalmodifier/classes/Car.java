package com.vitorrafael.javamarathon.oop.finalmodifier.classes;

public final class Car {

    // The Final modifier creates a constant;
    // The constant name must be upper-case underline separated if needed
    // They must be declared and initialized;

    // Final classes cannot be extended
    // Final methods cannot be overridden

    // When final is a reference type, it cannot be change, but its attributes
    // might be.
    public static final double LIMIT_SPEED = 250;
    public final Buyer BUYER = new Buyer();
    private String name;
    private String brand;


    // If static is used it's possible to initialize the constant in the
    // static initialization block, if it isn't static, it is possible to
    // initialize in the constructor

    public Buyer getBuyer() {
        return BUYER;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
