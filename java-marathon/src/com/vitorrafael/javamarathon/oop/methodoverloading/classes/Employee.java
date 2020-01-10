package com.vitorrafael.javamarathon.oop.methodoverloading;

public class Employee {

    private String name;
    private String cpf;
    private double salary;
    private String rg;



    // Constructors are called when instancing the class
    public Employee(String name, String cpf, double salary, String rg) {
        this(); // Calling the default constructor; Here it's not necessary
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.rg = rg;

    }

    // Constructors might also be overloaded
    public Employee() {

    }

    public void init(String name, String cpf, double salary) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
    }

    // Methods overloading -> Methods with the same name, but different number or type of params
    // JVM will know which one to call

    public void init(String name, String cpf, double salary, String rg) {
        init(name, cpf, salary);
        this.rg = rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRg() {
        return this.rg;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSalary() {
        return this.salary;
    }

    public void print() {
        System.out.println(this.name);
        System.out.println(this.cpf);
        System.out.println(this.salary);
        System.out.println(this.rg);
    }
}
