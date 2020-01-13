package com.vitorrafael.javamarathon.oop.abstractclasses.classes;

public abstract class Employee {
    // Abstract classes cannot be instantiated
    // They're used to be extended by subclasses


    // An abstract class may have abstract methods or concrete methods
    // Concrete Methods -> All subclasses want to have the same behavior
    // Abstract methods -> The behavior of the method might change accordingly to the subclass
    protected String name;
    protected String clt;
    protected double salary;

    public Employee() {

    }

    public Employee(String name, String clt, double salary) {
        this.name = name;
        this.clt = clt;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", clt='" + clt + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Abstract methods don't have a body
    public abstract void calculateSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
