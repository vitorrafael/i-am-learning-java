package com.vitorrafael.javamarathon.oop.staticmodifier.test;


import com.vitorrafael.javamarathon.oop.staticmodifier.classes.Client;

public class ClientTest {

    public static void main(String[] args) {


        Client c = new Client();
        Client c1 = new Client();
        Client c2 = new Client();

        System.out.println("Number of possible instalments:");
        for (int instalment : c.getInstallments()) {
            System.out.print(instalment + " ");
        }

        System.out.println("Size: " + c.getInstallments().length);
        System.out.println("Size: " + c1.getInstallments().length);
        System.out.println("Size: " + c2.getInstallments().length);
    }
}
