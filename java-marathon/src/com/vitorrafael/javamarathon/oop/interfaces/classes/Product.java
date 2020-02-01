package com.vitorrafael.javamarathon.oop.interfaces.classes;

public class Product implements Taxable, Transportable {
    // It's possible to implement multiple interfaces on one class
    private String name;
    private double weight;
    private double price;
    private double finalPrice;
    private double freightCost;

    public Product() {
    }

    public Product(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    // When overriding a method, its access value cannot be more restrictive
    @Override
    public void calculateTax() {
        this.finalPrice = this.price + (this.price * TAX);
    }

    @Override
    public void calculateFreight() {
        this.freightCost = this.price /this.weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", 'price with tax'=" + finalPrice +
                ", freightCost=" + freightCost +
                ", final price=" + (finalPrice+freightCost) +
                '}';
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public double getFreightCost() {
        return freightCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
