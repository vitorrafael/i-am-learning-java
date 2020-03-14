package com.vitorrafael.javamarathon.generics.test;

import java.util.*;

public class GenericsTest {

    public static void main(String[] args) {
        // Generics were introduced to generalize the type of an object

        // Type Erasure
        List<String> list = new ArrayList<>();
        // Generics only exist on compile time
        
        list.add("Hello World!");
        list.add("Ipsum Lorum");

        for(String obj : list) {
            System.out.println(obj);
        }

        add(list, 3l);
        for (String obj : list) {
            System.out.println(obj);
        }
    }

    public static void add(List list, long l) {
        // Since the generic type is not declared in List, it will executed
        list.add(l);
    }
}