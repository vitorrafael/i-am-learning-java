package com.vitorrafael.javamarathon.utils.dates.test;

import java.util.*;

public class DateTest {
    public static void main(String[] args) {

        // Most methods from Date are deprecated
        Date date = new Date();

        System.out.println(date);
        System.out.println(date.getTime()); // Miliseconds
    }
}
