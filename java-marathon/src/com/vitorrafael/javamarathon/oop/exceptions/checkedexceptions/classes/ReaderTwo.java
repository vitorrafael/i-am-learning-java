package com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.classes;

public class ReaderTwo implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Closing Reader Two");
    }
}
