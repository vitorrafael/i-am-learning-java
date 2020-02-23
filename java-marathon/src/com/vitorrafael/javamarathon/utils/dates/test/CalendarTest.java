package com.vitorrafael.javamarathon.utils.dates.test;

import java.util.*;

public class CalendarTest {

    public static void main(String[] args) {

        // Instead of Date use the abstract class Calendar

        Calendar c = Calendar.getInstance();
        System.out.println(c);

        // Get calendar info
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));

        Date date = c.getTime();
        System.out.println(date);

        // Add a hour
        c.add(Calendar.HOUR, 2);
        System.out.println(c.getTime());

        // Add calendar data without turning day/month/year
        System.out.println(c.getTime());
        c.roll(Calendar.MONTH, 14);
        System.out.println(c.getTime());
    }
}
