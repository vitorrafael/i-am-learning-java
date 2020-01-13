package com.vitorrafael.javamarathon.oop.abstractclasses.test;

import com.vitorrafael.javamarathon.oop.abstractclasses.classes.Manager;
import com.vitorrafael.javamarathon.oop.abstractclasses.classes.Seller;

public class EmployeeTest {

    public static void main(String[] args) {
        Manager manager = new Manager("Vítor", "987897-9", 2300);
        manager.calculateSalary();
        System.out.println(manager);

        Seller seller = new Seller("Ana", "98908-9",1500, 5000);
        seller.calculateSalary();
        System.out.println(seller);
    }
}
