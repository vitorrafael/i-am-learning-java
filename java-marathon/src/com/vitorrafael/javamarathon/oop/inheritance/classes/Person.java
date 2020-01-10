package com.vitorrafael.javamarathon.oop.inheritance.classes;

/* Initialization Sequence With Inheritance
 * 1st -> Memory space is allocated to the building of the object;
 * 2nd -> Each one of the attributes is created with a default value;
 * 3rd -> Superclass' constructor is called;
 * 4th -> Attributes initialization trough declaration and the init blocks of
 *      the superclasses are executed in the order that they were created
 * 5th -> Superclass' constructor code is called
 * 6th -> Repeats the 4th step with the subclass
 * 7th -> Subclass constructor is executed
 */

public class Person {
    // Inheritance is used to make code reusable and due to polymorphism
    // Protected allows attributes to be used by the class children
    protected String name;
    protected String cpf;
    protected Address address;

    static {
        System.out.println("Person Static Initialization Block ");
    }
    {
        System.out.println("Person Initialization Block 1");
    }

    public Person(String name) {
        System.out.println("Inside Person's Constructor");
        this.name = name;
    }

    public Person(String name, String cpf) {
        this(name);
        this.cpf = cpf;
    }

    public void print() {
        System.out.println("-------------------------------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Address: " + this.address.getStreet() + " - " + this.address.getDistrict());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
