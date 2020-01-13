package com.vitorrafael.javamarathon.oop.enumerators.test;

import com.vitorrafael.javamarathon.oop.enumerators.classes.Client;
import com.vitorrafael.javamarathon.oop.enumerators.classes.ClientType;

public class ClientTest {

    public static void main(String[] args) {
        Client client = new Client("Vitor", ClientType.JURIDIC_ENTITY, Client.PaymentType.CASH);
        System.out.println(client.getClientType().getId());
        System.out.println(client);
    }
}
