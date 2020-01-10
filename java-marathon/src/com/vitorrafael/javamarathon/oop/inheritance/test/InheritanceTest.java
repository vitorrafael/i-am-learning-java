package com.vitorrafael.javamarathon.oop.inheritance.test;

import com.vitorrafael.javamarathon.oop.inheritance.classes.Address;
import com.vitorrafael.javamarathon.oop.inheritance.classes.Employee;
import com.vitorrafael.javamarathon.oop.inheritance.classes.Person;

public class InheritanceTest {

    public static void main(String[] args) {

        Person p = new Person("Vitor");
        Address a = new Address();

        a.setStreet("Tv. Londrina, 62");
        a.setDistrict("Jardim America");

        p.setCpf("000.000.000-00");
        p.setAddress(a);

//        p.print();

        Employee e = new Employee("August");
        e.setCpf("444.555.666-88");
        e.setAddress(a);
        e.setSalary(1250.50);
//        e.print();
//        e.printSalaryReceipt();
    }
}
