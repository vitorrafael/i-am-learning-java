package com.vitorrafael.javamarathon.oop.inheritance.classes;

public class Employee extends Person {
    // extends -> Inherits from.  "Employee IS a Person"
    private double salary;

    static {
        System.out.println("Employee's Static Initialization Block");
    }
    {
        System.out.println("Employee's Initialization Block 1");
    }

    // If there is a constructor in the super class the children must have too
    public Employee(String name) {
        super(name); // Super is the "this" of the children classes
        System.out.println("Inside Employee's Constructor");
    }

    public Employee(String name, String cpf) {
        this(name);
        this.cpf = cpf;
    }

    // Method overriding -> Same name with same parameters
    public void print() {
        super.print(); // Calls the method from the parent class using the super keyword
        System.out.println("Salary: " + this.salary);
    }

    public void printSalaryReceipt() {
        // Since name is protected only children can access it
        System.out.println("I " + super.name + " was payed $" + this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
