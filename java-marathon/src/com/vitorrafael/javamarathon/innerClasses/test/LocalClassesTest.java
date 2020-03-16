package com.vitorrafael.javamarathon.innerClasses.test;

public class LocalClassesTest {

    private String name = "Vitor";
    public void doSomething() {
        String surname = "Rafael";
        class LocalClass {
            public void printExternalName() {
                // It's possible to access variables from within the method as well
                System.out.println(LocalClassesTest.this.name);
                System.out.println(surname);
            }
        }

        // This is the only way to reach the Local Class
        LocalClass localClass = new LocalClass();
        localClass.printExternalName();
    }

    public static void main(String[] args) {
        LocalClassesTest  externalClass = new LocalClassesTest();
        externalClass.doSomething();
    }

}
