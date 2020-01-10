package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.methods.Calculator;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Calling the method from a class instance
        calculator.sumTwoNumbers();
        calculator.subtractTwoNumbers();
        calculator.multiplyTwoNumbers(2, 3);

        double division = calculator.divideTwoNumbers(5, 0);
        System.out.println(division);

        calculator.printTwoDividedNumbers(20, 5);
        calculator.printTwoDividedNumbers(20, 0);

        int num1 = 5;
        int num2 = 10;
        calculator.changesTwoNumbers(num1, num2);

        // The values are not changed after the method
        System.out.println("Outside the method: ");
        System.out.println(num1);
        System.out.println(num2);


        int[] numbers = new int[]{1, 2, 3, 4, 5};
        calculator.sumArray(numbers);

        // Using varargs allows to pass the arguments comma-separated
        calculator.sumWithVarArgs(1, 2, 3, 4, 5);
    }
}
