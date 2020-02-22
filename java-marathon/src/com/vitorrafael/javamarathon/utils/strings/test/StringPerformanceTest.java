package com.vitorrafael.javamarathon.utils.strings.test;

public class StringPerformanceTest {

    public static void main(String[] args) {
        long start, end;

        start = System.currentTimeMillis();
        concatString(30000);
        end = System.currentTimeMillis();

        System.out.println("String: " + (end - start));

        start = System.currentTimeMillis();
        concatStringBuilder(1000000);
        end = System.currentTimeMillis();

        System.out.println("StringBuilder: " + (end - start));

        start = System.currentTimeMillis();
        concatStringBuffer(1000000);
        end = System.currentTimeMillis();

        System.out.println("StringBuffer: " + (end - start));
    }

    private static void concatString(int size) {
        String string = "";

        for(int i = 0; i < size; i++) {
            string += i;
        }
    }

    private static void concatStringBuilder(int size) {
        StringBuilder sb = new StringBuilder(size); // Multi-thread

        for(int i = 0; i < size; i++) {
            sb.append(i);
        }
    }

    private static void concatStringBuffer(int size) {
        StringBuffer sb = new StringBuffer(size); // Single-thread

        for(int i = 0; i < size; i++) {
            sb.append(i);
        }
    }
}
