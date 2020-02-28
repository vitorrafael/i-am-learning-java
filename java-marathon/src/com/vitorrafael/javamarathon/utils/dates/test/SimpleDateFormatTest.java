package com.vitorrafael.javamarathon.utils.dates.test;

import java.util.*;
import java.text.*;

public class SimpleDateFormatTest {

    public static void main(String[] args) {
        // Allows to customize date format
        Calendar c = Calendar.getInstance();

        // Pass a date format to the object constructor
        String format = "dd-MM-yy 'at' G";
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        System.out.println(formatter.format(c.getTime()));
    }

}
