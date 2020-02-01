package com.vitorrafael.javamarathon.oop.polymorphism.classes;

public class DatabaseDAOImp implements InterfaceDAO {

    @Override
    public void save() {
        System.out.println("Saving on database...");
    }

}
