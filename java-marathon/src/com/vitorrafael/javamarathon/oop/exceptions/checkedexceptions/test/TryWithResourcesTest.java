package com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.test;

import com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.classes.ReaderOne;
import com.vitorrafael.javamarathon.oop.exceptions.checkedexceptions.classes.ReaderTwo;

import java.io.*;

public class TryWithResourcesTest {

    public static void main(String[] args) {

    }

    public static void readFileNew() {
        try(ReaderOne readerOne = new ReaderOne();
            ReaderTwo readerTwo = new ReaderTwo()) {
            // Classes declared in the try must implement 'autocloseable'
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void readFileOld() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
