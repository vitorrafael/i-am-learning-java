package com.vitorrafael.javamarathon.oop.exceptions.customexceptions;

public class Employee extends Person {
    @Override
    public void save() throws InvalidLoginException {
        // An overridden method might have a different number of exceptions
        // But it cannot throw a superclass from any exception declared before

    }
}
