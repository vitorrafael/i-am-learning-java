package com.vitorrafael.javamarathon.oop.abstractclasses.classes;

public class Seller extends Employee {

    private double totalSales;

    public Seller(double totalSales) {
        this.totalSales = totalSales;
    }

    public Seller(String name, String clt, double salary, double totalSales) {
        super(name, clt, salary);
        this.totalSales = totalSales;
    }

    @Override
    public void calculateSalary() {
        // Overrides method from super abstract class
        this.salary = salary + (totalSales * 0.05);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}
