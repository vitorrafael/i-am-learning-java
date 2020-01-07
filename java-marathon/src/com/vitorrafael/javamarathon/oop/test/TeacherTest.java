package com.vitorrafael.javamarathon.oop.test;

import com.vitorrafael.javamarathon.oop.methods.Teacher;

public class TeacherTest {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        teacher.cpf = "000.000.000-00";
        teacher.name = "Vitor";
        teacher.rg = "000000000";
        teacher.register = "00.000-0";

        teacher.print(teacher);
        // Reference types can have their values changed within the method
        System.out.println(teacher.name);

        teacher.printWithThis();
    }
}
