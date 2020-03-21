package com.vitorrafael.javamarathon.JDBC.test;

import java.util.Scanner;
import com.vitorrafael.javamarathon.JDBC.classes.CustomerCRUD;
import com.vitorrafael.javamarathon.JDBC.classes.CarCRUD;


public class TestCRUD {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int operation;
        while (true) {
            menu();
            operation = Integer.parseInt(scanner.nextLine());

            if (operation == 0) {
                System.out.println("Exiting...");
                break;
            }

            if(operation == 1) {
                customerMenu();
                operation = Integer.parseInt(scanner.nextLine());
                CustomerCRUD.execute(operation);
            }

            if(operation == 2) {
                carMenu();
                operation = Integer.parseInt(scanner.nextLine());
                CarCRUD.execute(operation);
            }
        }
    }

    private static void menu() {
        System.out.println("Select an option");
        System.out.println("1 - Customer");
        System.out.println("2 - Car");
        System.out.println("0 - Exit");
    }

    public static void customerMenu() {
        System.out.println("Insert the number according to the operation:");
        System.out.println("1 - Insert customer");
        System.out.println("2 - Update customer");
        System.out.println("3 - List all customers");
        System.out.println("4 - List customers by search term");
        System.out.println("5 - Delete customer");
        System.out.println("9 - Back");
    }

    public static void carMenu() {
        System.out.println("Insert the number according to the operation:");
        System.out.println("1 - Insert car");
        System.out.println("2 - Update car");
        System.out.println("3 - List all car");
        System.out.println("4 - List car by search term");
        System.out.println("5 - Delete car");
        System.out.println("9 - Back");
    }
}
