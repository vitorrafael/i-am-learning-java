package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.methodoverloading.Employee;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee = new Employee("Rafael", "000.000.000-00", 1250.5, "101010-12");
        Employee employee1 = new Employee();
        employee.print();
        employee1.print();
    }
}
