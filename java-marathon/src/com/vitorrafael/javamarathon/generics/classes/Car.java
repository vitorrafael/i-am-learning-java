package com.vitorrafael.javamarathon.generics.classes;

public class Car {

    private String name;

    public Car() {}

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Carro <%s>", this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
