package com.vitorrafael.javamarathon.JDBC.classes;

import com.vitorrafael.javamarathon.JDBC.db.CustomerTable;

import java.util.List;
import java.util.Scanner;

public class CustomerCRUD {

    private static Scanner scanner = new Scanner(System.in);

    public static void execute(int operation) {
        switch(operation) {
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                list();
                break;
            case 4:
                System.out.println("Write the search term: ");
                String searchTerm = scanner.nextLine();
                listBySearchTerm(searchTerm);
                break;
            case 5:
                delete();
                break;
        }
    }

    public static void insert() {
        Customer customer = new Customer();

        System.out.print("Name: ");
        customer.setName(scanner.nextLine());
        System.out.print("CPF: ");
        customer.setCpf(scanner.nextLine());

        CustomerTable.save(customer);
    }

    public static List<Customer> list() {
        List<Customer> customerList = CustomerTable.selectAll();
        for (int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            System.out.printf("| %d | %s | %s \n", i, customer.getName(), customer.getCpf());
        }
        return customerList;
    }

    private static void listBySearchTerm(String searchTerm) {
        List<Customer> customerList = CustomerTable.selectAllByName(searchTerm);
        for(int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            System.out.printf("| %d | %s | %s \n", i, customer.getName(), customer.getCpf());
        }
    }

    private static void update() {
        System.out.println("Select one of the  following customers: ");
        List<Customer> customerList = list();
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerList.get(id);
        System.out.println("New name: (Press enter to keep the same) ");
        String name = scanner.nextLine();
        System.out.println("New CPF: (Press enter to keep the same) ");
        String cpf = scanner.nextLine();
        if(!name.isEmpty()) {
            customer.setName(name);
        }
        if(!cpf.isEmpty()) {
            customer.setCpf(cpf);
        }

        CustomerTable.update(customer);
    }

    public static void delete() {
        System.out.println("Choose one of the following customers to delete: ");
        List<Customer> customerList = list();
        int index = Integer.parseInt(scanner.nextLine());
        System.out.printf("Are you sure you want to delete '%s': (Y/N)", customerList.get(index).getName());
        String response = scanner.nextLine();
        if(response.toUpperCase().startsWith("Y")) {
            CustomerTable.delete(customerList.get(index));
        }
    }
}
