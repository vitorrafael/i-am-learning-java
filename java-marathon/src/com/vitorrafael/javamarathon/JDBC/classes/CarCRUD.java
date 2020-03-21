package com.vitorrafael.javamarathon.JDBC.classes;

import com.vitorrafael.javamarathon.JDBC.db.CarTable;

import java.util.List;
import java.util.Scanner;

public class CarCRUD {

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

        Car car = new Car();
        System.out.print("Name: ");
        car.setName(scanner.nextLine());
        System.out.print("Plate: ");
        car.setPlate(scanner.nextLine());

        System.out.println("Select one of the  following customers: ");
        List<Customer> customerList = CustomerCRUD.list();
        int index = Integer.parseInt(scanner.nextLine());
        Customer customer = customerList.get(index);
        car.setCustomer(customer);
        CarTable.save(car);
    }

    private static List<Car> list() {
        List<Car> carList = CarTable.selectAll();
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            System.out.printf("| %d | %s | %s  | %s \n", i, car.getName(), car.getPlate(), car.getCustomer().getName());
        }
        return carList;
    }

    private static void listBySearchTerm(String searchTerm) {
        List<Car> carList = CarTable.selectAllByName(searchTerm);
        for(int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            System.out.printf("| %d | %s | %s  | %s \n", i, car.getName(), car.getPlate(), car.getCustomer().getName());
        }
    }

    private static void update() {
        System.out.println("Select one of the  following cars: ");
        List<Car> carList = list();
        int id = Integer.parseInt(scanner.nextLine());
        Car car = carList.get(id);
        System.out.println("New name: (Press enter to keep the same) ");
        String name = scanner.nextLine();
        System.out.println("New Plate: (Press enter to keep the same) ");
        String plate = scanner.nextLine();
        if(!name.isEmpty()) {
            car.setName(name);
        }
        if(!plate.isEmpty()) {
            car.setPlate(plate);
        }

        CarTable.update(car);
    }

    public static void delete() {
        System.out.println("Choose one of the following cars to delete: ");
        List<Car> carList = list();
        int index = Integer.parseInt(scanner.nextLine());
        System.out.printf("Are you sure you want to delete '%s': (Y/N)", carList.get(index).getName());
        String response = scanner.nextLine();
        if(response.toUpperCase().startsWith("Y")) {
            CarTable.delete(carList.get(index));
        }
    }
}
