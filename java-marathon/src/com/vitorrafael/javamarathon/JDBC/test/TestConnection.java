package com.vitorrafael.javamarathon.JDBC.test;

import com.vitorrafael.javamarathon.JDBC.classes.Buyer;
import com.vitorrafael.javamarathon.JDBC.db.BuyerTable;

import java.util.List;


public class TestConnection {
    public static void main(String[] args) {
        List<Buyer> buyerList = selectAllByName("itor");
        if(buyerList != null) {
            System.out.println(buyerList);
        }
    }

    public static void insert() {
        Buyer buyer = new Buyer();
        BuyerTable.save(buyer);
    }

    public static void delete() {
        Buyer buyer = new Buyer();
        buyer.setId(1);
        BuyerTable.delete(buyer);
    }

    public static void update() {
        Buyer buyer = new Buyer();
        BuyerTable.update(buyer);
    }

    public static  List<Buyer> selectAll() {
        return BuyerTable.selectAll();
    }

    public static List<Buyer> selectAllByName(String name) {
        return BuyerTable.selectAllByName(name);
    }
}
