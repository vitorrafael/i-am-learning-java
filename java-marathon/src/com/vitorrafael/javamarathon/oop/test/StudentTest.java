package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.classes.Student;

public class StudentTest {

    public static void main(String[] args) {

        // Class name + variable name = new Constructor()
        Student student = new Student();

        student.name = "Vitor";
        student.register = "0701";
        student.age = 18;

        System.out.println(student.name);
        System.out.println(student.register);
        System.out.println(student.age);
    }
}
