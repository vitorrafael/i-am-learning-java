package com.vitorrafael.javamarathon.utils.dates.test;

import java.util.*;
import java.text.*;

public class LocaleTest {

    public static void main(String[] args) {

        // The Locale class allows to manipulate the localization

        // The constructor takes the language and the country
        Locale locale = new Locale("pt", "br");
        Locale locale2 = new Locale("de", "deu");
        Locale locale3 = new Locale("ja", "jpn");

        // Using Locale to change calendar attributes
        Calendar c = Calendar.getInstance();

        c.set(2015, Calendar.DECEMBER, 23);

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locale2);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locale3);

        System.out.println(df.format(c.getTime()));
        System.out.println(df2.format(c.getTime()));
        System.out.println(df3.format(c.getTime()));

        // Get the Language
        System.out.println(locale2.getDisplayLanguage(locale));
        System.out.println(locale2.getDisplayLanguage());
        System.out.println(locale2.getDisplayLanguage(locale3));


        // Get Country language and code
        System.out.println(locale2.getDisplayName(locale));
        System.out.println(locale2.getDisplayName());
        System.out.println(locale2.getDisplayName(locale3));

        // Get Country Name code
        System.out.println(locale.getCountry());
        System.out.println(locale2.getCountry());
        System.out.println(locale3.getCountry());
    }

}
