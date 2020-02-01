package com.vitorrafael.javamarathon.oop.polymorphism.test;

import com.vitorrafael.javamarathon.oop.polymorphism.classes.DatabaseDAOImp;
import com.vitorrafael.javamarathon.oop.polymorphism.classes.FileDAOImp;
import com.vitorrafael.javamarathon.oop.polymorphism.classes.InterfaceDAO;

public class DAOTest {

    public static void main(String[] args) {

        // By declaring with the Interface, it is possible to change the
        // referenced object by just changing the object in the initialization
        InterfaceDAO fileDAO = new DatabaseDAOImp();
        fileDAO.save();
    }
}
