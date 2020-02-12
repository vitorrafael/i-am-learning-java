package com.vitorrafael.javamarathon.oop.assertions.test;

public class AssertionTest {

    public static void main(String[] args) {
        // -ea -> enable assertions
        // -da -> disable assertions
        calculateSalary(2000);
        weekDay(8);
    }

    private static void calculateSalary(double salary) {
        // This condition must always be true, otherwise there is an error in the code
        assert (salary > 0) : "Salary should not be smaller or equal to 0";
        // Assertions are ignored by default and must be activated in the JVM options
        // There is no need to use if-else after the assert
        // Asserts should not be used in public methods, only in private
        System.out.println("Salary: " + salary);
    }

    public static void weekDay(int day) {
        // If you're 100% sure that the variable cannot assume other value
        // it is possible to use the assert in public methods
        switch (day){
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            default: assert false;
        }
    }
}
