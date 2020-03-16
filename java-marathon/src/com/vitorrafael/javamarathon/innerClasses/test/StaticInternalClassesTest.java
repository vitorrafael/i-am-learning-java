package com.vitorrafael.javamarathon.innerClasses.test;

class ExternalClass {
    static class Internal {
        public void greet() {
            System.out.println("Hello");
        }
    }
}

public class StaticInternalClassesTest {

    public static void main(String[] args) {

        // External class behave just like attributes and don't need to be instantiate
        ExternalClass.Internal internal = new ExternalClass.Internal();
        internal.greet();
    }
}
