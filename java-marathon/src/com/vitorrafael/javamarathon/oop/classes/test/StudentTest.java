package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.classes.Student;

public class StudentTest {

    public static void main(String[] args) {

        // Class name + variable name = new Constructor()
        Student student = new Student();

        student.setName("Vitor");
        student.setAge(-1);
        student.setGrades(new double[]{10, 8, 3, 4, 5});

        student.print();
        System.out.println(student.getName());
        student.getAverage();
    }
}
