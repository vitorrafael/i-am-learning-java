package com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.classes;

public class ReaderOne implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Closing Reader One");
    }
}
