package com.vitorrafael.javamarathon.generics.test;

import java.util.*;

abstract class Animal {

    public abstract void check();

}

class Dog extends Animal implements Comparable{

    @Override
    public void check() {
        System.out.println("Checking dog.");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Cat extends Animal {

    @Override
    public void check() {
        System.out.println("Checking cat.");
    }
}

public class WildcardTest {

    public static void main(String[] args) {

        Dog[] dogs = {new Dog(), new Dog()};
        Cat[] cats = {new Cat(), new Cat()};

        checkAnimals(dogs);
        checkAnimals(cats);

        List<Dog> dogsList = new ArrayList<>();
        List<Cat> catsList = new ArrayList<>();

        dogsList.add(new Dog());
        dogsList.add(new Dog());

        catsList.add(new Cat());
        catsList.add(new Cat());

        // We can't pass subclasses of a type to collections
        // checkAnimals(dogsList);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog());
        animalList.add(new Cat());

        // Once the code is compiled, Java doesn't understand generics anymore
        checkAnimals(animalList);

        // Now it is allowed
        checkAnimals(dogsList);
        checkAnimals(catsList);

        sortList(dogsList);
    }

    public static void checkAnimals(Animal[] animals) {
        for(Animal animal : animals) {
            animal.check();
        }
    }

    // Wildcard is the interrogation point -> ?
    // Basically, it allows to pass any subclass of a type
    public static void checkAnimals(List<? extends Animal> animals) {

        for(Animal animal : animals) {
            animal.check();
        }
        // This is not allowed
        // animals.add(new Dog());
    }

    public static void checkDogsList(List<? super Dog> dogs) {

        // Any Dog class or a superclass of Dog
        dogs.add(new Dog());
        dogs.add(new Dog());
    }

    public static void sortList(List<? extends  Comparable> list) {
        // It's only possible to sort IF the list type has the comparable interface
        Collections.sort(list);

    }
}
