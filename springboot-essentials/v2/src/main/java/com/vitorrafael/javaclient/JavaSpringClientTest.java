package com.vitorrafael.javaclient;


import com.vitorrafael.model.Student;

import java.util.List;

public class JavaSpringClientTest {

    public static void main(String[] args) {
        JavaClientDAO javaClientDAO = new JavaClientDAO();

        Student newStudent = new Student();
        newStudent.setName("Rose Freitas");
        newStudent.setEmail("rosefreitas@yahoo.com.br");

        Student getStudent = javaClientDAO.findByIdWithObject(27);
        System.out.println(getStudent);

        Student postStudent = javaClientDAO.saveWithForObject(newStudent);
        System.out.println(postStudent);

        List<Student> students = javaClientDAO.listAllWithPageable();

        for(Student student : students) {
            System.out.println(student);
        }
    }
}
