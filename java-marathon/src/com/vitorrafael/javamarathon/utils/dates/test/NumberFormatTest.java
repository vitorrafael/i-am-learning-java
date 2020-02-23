package com.vitorrafael.javamarathon.utils.dates.test;

import java.text.*;
import java.util.*;

public class NumberFormatTest {

    public static void main(String[] args) {
        float num = 1222223.4567f;

        Locale localeJP = new Locale("de", "deu");

        // There are 4 number formats
        NumberFormat[] nb = new NumberFormat[4];

        nb[0] = NumberFormat.getInstance();
        nb[1] = NumberFormat.getInstance(localeJP);
        nb[2] = NumberFormat.getCurrencyInstance();
        nb[3] = NumberFormat.getCurrencyInstance(localeJP);

        for(NumberFormat nf : nb) {
            System.out.println(nf.format(num));
        }

        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits());
        nf.setMaximumFractionDigits(4);
        System.out.println(nf.getMaximumFractionDigits());

        String value = "1222223.4567";
        try {
            System.out.println(nf.parse(value));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
