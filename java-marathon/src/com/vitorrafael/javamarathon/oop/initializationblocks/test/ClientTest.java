package com.vitorrafael.javamarathon.oop.initializationblocks.test;

import com.vitorrafael.javamarathon.oop.initializationblocks.classes.Client;

public class ClientTest {

    public static void main(String[] args) {


        Client c = new Client();

        System.out.println("Number of possible instalments:");
        for(int instalment : c.getInstallments()) {
            System.out.print(instalment + " ");
        }
    }
}
