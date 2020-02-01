package com.vitorrafael.javamarathon.oop.polymorphism.classes;

public class Seller extends Employee {
    private double totalSales;


    public Seller(String name, float salary, double totalsales) {
        super(name, salary);
        this.totalSales = totalsales;
    }

    @Override
    public void calculateSalary() {
        this.salary = this.salary + (this.totalSales * 0.05);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}
