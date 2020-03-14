package com.vitorrafael.javamarathon.generics.test;

import com.vitorrafael.javamarathon.generics.classes.*;
import java.util.*;

public class GenericClassesTest {

    public static void main(String[] args) {

        List<Car> availableCars = new ArrayList<>();
        availableCars.add(new Car("GOL"));
        availableCars.add(new Car("BMW"));

        RentableObjects<Car> rentableCars = new RentableObjects<>(availableCars);

        Car car = rentableCars.getAvailableObject();
        rentableCars.returnObject(car);

        List<Computer> availableComputers = new ArrayList<>();
        availableComputers.add(new Computer("HP"));
        availableComputers.add(new Computer("Dell"));
        availableComputers.add(new Computer("Lenovo"));

        RentableObjects<Computer> rentableComputers = new RentableObjects<>(availableComputers);
        Computer computer = rentableComputers.getAvailableObject();
        rentableComputers.returnObject(computer);
    }
}

// List -> E for element; Other thing -> T for type
// Here we define that the class will have an type T
class RentableObjects<T> {

    // Now we can use this type T in methods and attributes of the class
    private List<T> availableObjects = new ArrayList<>();

    public RentableObjects(List<T> availableObjectsObjects) {
        this.availableObjects = availableObjectsObjects;
    }

    public T getAvailableObject() {
        T object = availableObjects.remove(0);
        System.out.println("Renting Object");
        System.out.println("Available objects: " + this.availableObjects);
        return object;
    }

    public void returnObject(T obj) {
        System.out.println("Returning " + obj);
        this.availableObjects.add(obj);
        System.out.println("Available Objects: " + this.availableObjects);
    }
}
