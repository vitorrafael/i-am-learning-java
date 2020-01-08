package com.vitorrafael.javamarathon.oop.classes;

public class Student {

    // We have to encapsulate attributes using access modifiers
    private String name;
    private int age;
    private double[] grades;
    private boolean approved;

    // Setters must be named setAttributename
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age must be a non-negative number");
            return;
        }
        this.age = age;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    // Getters must be named getAttributename
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double[] getGrades() {
        return this.grades;
    }

    public void print() {
        System.out.println(this.name);
        System.out.println(this.age);
        for(double grade : this.grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void getAverage() {
        if(this.grades == null) {
            return;
        }

        double average = 0;

        for(double grade : this.grades) {
            average += grade;
        }

        average = average/this.grades.length;

        System.out.println("The student's average is: " + average);
        this.approved = average >= 6 ? true : false;
        System.out.print("Situation: ");
        System.out.println(this.approved ?" Approved" : "Not approved");
    }
}
