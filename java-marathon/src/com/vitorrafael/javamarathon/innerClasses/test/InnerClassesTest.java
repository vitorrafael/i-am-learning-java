package com.vitorrafael.javamarathon.innerClasses.test;

public class InnerClassesTest {

    public static void main(String[] args) {

        External externalClass = new External();

        // We have to access the outer class to have access to the inner
        External.Internal internalClass =  externalClass.new Internal();
        internalClass.printExternalName();

        // It's also possible to do it this way
        External.Internal internalClassTwo = new External().new Internal();
        internalClassTwo.printInternalName();
    }
}

class External {

    private String name = "Vitor";

    // Here we have an internal class
    // It has access to all attributes and methods from the external
    class Internal {
        private String name = "Rafael";
        public void printExternalName() {
            System.out.println(External.this.name);
        }
        // The 'this' keyword refers to the object from the internal class
        public void printInternalName() {
            System.out.println(this.name);
        }

    }
}
