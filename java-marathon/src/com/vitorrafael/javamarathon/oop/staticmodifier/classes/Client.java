package com.vitorrafael.javamarathon.oop.staticmodifier.classes;

public class Client {

    // 0 -> Static Initialization Blocks are called just once
    // 1st -> Allocates memory space to the created object
    // 2nd -> Each attribute is created and initialized
    // 3rd -> Initialization block is executed
    // 4th -> Constructor is called

    private static int[] installments;

    // Static Initialization blocks are called just once
    static {
        installments = new int[100];
        System.out.println("Within Initialization Block");
        for(int i=1; i <= 100; i++) {
            installments[i-1] = i;
        }
    }

    // Multiple Static Init Blocks are executed in the order they're created
    static {
        System.out.println("Static block 2");
    }

    public Client() {
        System.out.println("Within constructor;");
        for(int instalment : this.installments) {
            System.out.print(instalment + " ");
        }
        System.out.println();
    }

    public static int[] getInstallments() {
        return Client.installments;
    }

    public static void setInstallments(int[] installments) {
        Client.installments = installments;
    }
}
