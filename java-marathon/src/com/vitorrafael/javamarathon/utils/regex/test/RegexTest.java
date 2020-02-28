package com.vitorrafael.javamarathon.utils.regex.test;

import java.util.regex.*;

public class RegexTest {

    public static void main(String[] args) {

        // There are two classes to use Regex - Pattern and Matcher
        // Pattern -> pattern to be matched
        // Matcher -> Matching object.
        // Regex don't reuse characters already matched
        String regex = "aba";
        String text = "abababa";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Text: " + text);
        System.out.println("Expression: " + matcher.pattern());

        System.out.println("Indexes where the pattern was found: ");

        // While there is still a match
        while(matcher.find()) {
            System.out.print(matcher.start() + " ");
        }

        // Meta-characters makes the regex easier
        // \d -> Looks for the digits
        // \D -> Everything that is not digit
        // \s -> Looks for white-space
        // \S -> Not white character
        // \w -> Alpha-Characters a-z, A-Z, digits and underline
        // \W -> Everything that is not a word
        regex = "\\W";
        text = "ababa21312312381273 817ababc";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);

        System.out.println("\nText: " + text);
        System.out.println("Expression: " + matcher.pattern());

        System.out.println("Indexes where the pattern was found: ");

        // While there is still a match
        while(matcher.find()) {
            System.out.print(matcher.start() + " ");
        }

        // Look for a range of characters
        // We use bracers []
        // From a to z -> a-z
        regex = "[a-zA-C0-8]";
        text = "cadeBASE123456789";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);

        System.out.println("\nText: " + text);
        System.out.println("Expression: " + matcher.pattern());

        System.out.println("Indexes where the pattern was found: ");

        // While there is still a match
        while(matcher.find()) {
            System.out.print(matcher.start() + " ");
        }

        // Looking for Hexadecimal numbers
        regex = "0[xX][0-9a-fA-F]";
        text = "12 0x 0X 0xFFABC 0x10G 0x1";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);

        System.out.println("\nText: " + text);
        System.out.println("Expression: " + matcher.pattern());

        System.out.println("Patterns found: ");

        // While there is still a match
        while(matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group());
        }
    }
}
