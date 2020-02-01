package com.vitorrafael.javamarathon.oop.interfaces.classes;

public interface Taxable {
    // Most of the time interfaces are named as adjectives

    // Interfaces don't have any concrete methods
    // All methods are abstract and public
    // All attributes are constants, and public, and static
    // It's impossible to instantiate an interface

    double TAX = 0.2;

    void calculateTax();
}
