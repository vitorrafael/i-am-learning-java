package com.vitorrafael.javamarathon.oop.methods;

public class Calculator {

    // access modifier + return type + method name + (params)
    public void sumTwoNumbers() {
        System.out.println(5 + 5);
    }

    public void subtractTwoNumbers() {
        System.out.println(5 - 5);
    }

    public void multiplyTwoNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    public double divideTwoNumbers(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
            // This is an unreachable line
        }
        return 0;
        }

    public void printTwoDividedNumbers(double num1, double num2) {
        if (num2 != 0) {
            System.out.println(num1/num2);
        } else {
            System.out.println("Impossible to divide by 0");
        }
    }

    public void changesTwoNumbers(int num1, int num2) {
        num1 = 30;
        num2 = 25;
        System.out.println("Within the method: ");
        System.out.println(num1);
        System.out.println(num2);
    }

    public void sumArray(int[] numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }

    public void sumWithVarArgs(int... numbers) {
        // Only one varargs is allowed
        // If there are more parameters, the varargs must be the last one
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        System.out.println(sum);
    }

}
