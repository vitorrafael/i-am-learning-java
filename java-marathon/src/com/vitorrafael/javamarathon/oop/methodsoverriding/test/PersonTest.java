package com.vitorrafael.javamarathon.oop.methodsoverriding.test;

import com.vitorrafael.javamarathon.oop.methodsoverriding.classes.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();

        p.setName("Vitor");
        p.setAge(18);

        System.out.println(p);

    }
}
