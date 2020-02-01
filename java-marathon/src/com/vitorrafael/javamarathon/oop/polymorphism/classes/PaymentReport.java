package com.vitorrafael.javamarathon.oop.polymorphism.classes;

public class PaymentReport {

//    public void managerPaymentReport(Manager manager) {
//        System.out.println("---------------------------------");
//        System.out.println("Generating Manager Payment Report");
//        manager.calculateSalary();
//        System.out.println("Name: " + manager.getName());
//        System.out.println("Salary: $" + manager.getSalary());
//    }
//
//    public void sellerPaymentReport(Seller seller) {
//        System.out.println("--------------------------------");
//        System.out.println("Generating Seller Payment Report");
//        seller.calculateSalary();
//        System.out.println("Name: " + seller.getName());
//        System.out.println("Salary: $" + seller.getSalary());
//    }

    public void genericPaymentReport(Employee emp) {
        // emp -> Polymorphic parameter
        System.out.println("-------------------------");
        System.out.println("Generation Payment Report");
        emp.calculateSalary();
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: $" + emp.getSalary());

        // It's possible to use casting to, making a more broad type
        // be referenced by a more specific
        // But it might raise a ClassCastException, in order to overcome
        // that, use a 'instanceof'
        if(emp instanceof Manager) {
            Manager man = (Manager) emp;
            System.out.println("Profit Share: " + man.getProfitShare());
        }

        if(emp instanceof Seller) {
            // It's possible to use a direct cast
            // ((CastType) varName).Method();
            System.out.println("Total Sales: " + ((Seller) emp).getTotalSales());
        }

    }
}
