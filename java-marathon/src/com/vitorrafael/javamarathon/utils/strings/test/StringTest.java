package com.vitorrafael.javamarathon.utils.strings.test;

public class StringTest {

    public static void main(String[] args) {

        // Strings can be created in two ways

        String name = "Vitor";

        // Creates an reference variable to an object of type String that gets
        // a String from the String pool
        String surname = new String(" Veeck");

        System.out.println(name + surname);

        // Strings are immutable
        // Java creates a new String when concatenating
        // The reference name reference won't change
        // String constant pool -> Where the Java stores the strings without any duplicates
        name.concat(surname);
        String fullName = name.concat(surname);
        System.out.println(fullName);
        System.out.println(name);

        // It is possible to return the character at a given index
        System.out.println(fullName.charAt(3));

        // Comparing two strings with different cases
        System.out.println(name.equalsIgnoreCase("VITOR"));

        // Comparing two strings -> USE EQUALS();
        System.out.println(name.equals("Vitor"));

        // Length() returns the length of the string
        System.out.println(name.length());

        // Replace a character by another
        String test = "aoa";
        test = test.replace('o', 'a');
        System.out.println(test);

        // Substring() -> Returns a substring of the string
        // Start is 0-index bases, end is 1-index based
        System.out.println(name.substring(1, 4));

        // Trim() -> Removes all surrounding white-spaces
        System.out.println("         Hello World      ".trim());

    }
}
