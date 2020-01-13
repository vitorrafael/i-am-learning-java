package com.vitorrafael.javamarathon.oop.enumerators.classes;

public class Client {
    public enum PaymentType {
        // Enumerators can also be an internal class
        CASH, INSTALLMENT
    }

    private String name;
    private ClientType clientType;
    private PaymentType paymentType;

    public Client(String name, ClientType clientType, PaymentType paymentType) {
        this.name = name;
        this.clientType = clientType;
        this.paymentType = paymentType;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", type=" + clientType +
                ", paymentType=" + paymentType +
                ", number=" + clientType.getType() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
