package com.vitorrafael.javamarathon.oop.polymorphism.test;

import com.vitorrafael.javamarathon.oop.polymorphism.classes.Manager;
import com.vitorrafael.javamarathon.oop.polymorphism.classes.PaymentReport;
import com.vitorrafael.javamarathon.oop.polymorphism.classes.Seller;

public class PolymorphismTest {

    /*
     * Polymorphism helps to reduce the number of code lines.
     *
     *
     */
    public static void main(String[] args) {
        Manager man = new Manager("Jerry", 5000, 2000);
        Seller sel = new Seller("Rodrigo", 1010, 20000);

        PaymentReport report = new PaymentReport();

        // report.managerPaymentReport(man);
        // report.sellerPaymentReport(sel);

        // Widening cast -> A superclass variable (generic) references a more
        // specific type of variable
        report.genericPaymentReport(man);
        report.genericPaymentReport(sel);
    }
}
