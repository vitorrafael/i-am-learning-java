package com.vitorrafael.javamarathon.oop.interfaces.test;

import com.vitorrafael.javamarathon.oop.interfaces.classes.Product;

public class ProductTest {

    public static void main(String[] args) {

        Product p = new Product("Notebook", 4, 300);

        p.calculateFreight();
        p.calculateTax();
        System.out.println(p);
    }
}
