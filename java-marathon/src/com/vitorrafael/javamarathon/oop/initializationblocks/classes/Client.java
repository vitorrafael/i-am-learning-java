package com.vitorrafael.javamarathon.oop.initializationblocks.classes;

public class Client {

    // 1st -> Allocates memory space to the created object
    // 2nd -> Each attribute is created and initialized
    // 3rd -> Initialization block is executed
    // 4th -> Constructor is called

    private int[] installments;

    // Initialization blocks must be before the constructors
    {
        installments = new int[100];
        System.out.println("Within Initialization Block");
        for(int i=1; i <= 100; i++) {
            installments[i-1] = i;
        }
    }

    public Client() {
        System.out.println("Within constructor;");
        for(int instalment : this.installments) {
            System.out.print(instalment + " ");
        }
    }

    public int[] getInstalments() {
        return this.installments;
    }

    public void setInstalments(int[] instalments) {
        this.installments = instalments;
    }
}
