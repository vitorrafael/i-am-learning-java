package com.vitorrafael.javamarathon.generics.classes;

public class Computer {

    private String name;

    public Computer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Computer <%s>", this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
