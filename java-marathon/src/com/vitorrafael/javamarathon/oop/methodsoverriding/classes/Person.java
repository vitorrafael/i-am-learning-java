package com.vitorrafael.javamarathon.oop.methodsoverriding.classes;

public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        // Same access modifier + Same return type + Same name + Same parameters
        // Overriding method inherited from Object
        // Adapts the superclass method behavior to the children
        return "Person(name: " + this.name + ", age: " + this.age + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
