package com.vitorrafael.javamarathon.utils.strings.test;

public class StringBuilderTest {

    public static void main(String[] args) {
        // StringBuilder won't create a string in the StringPoll
        // StringBuilder and StringBuffer have the same methods just with the threading differences
        String s = "Comum sentence";

        StringBuilder sb = new StringBuilder(10);
        // When printing a StringBuilder, the method toString() is called
        // Append recycles the object
        sb.append(s);

        System.out.println(sb);
        System.out.println(sb.reverse()); // Reverse the String
        System.out.println(sb.delete(1, 3)); // Removes char from start to end
        // Start -> 0 Indexed
        // End -> 1 Indexed
        sb.reverse();
        System.out.println(sb.insert(0, "#"));
    }

}
