package com.vitorrafael.javamarathon.oop.methods;

public class Teacher {

    public String cpf;
    public String register;
    public String name;
    public String rg;

    public void print(Teacher teacher) {
        System.out.println(teacher.name);
        System.out.println(teacher.register);
        System.out.println(teacher.rg);
        System.out.println(teacher.cpf);
        teacher.name = "Changed";
    }

    public void printWithThis() {
        System.out.println("Printing with this");
        // The this keyword allows to access the attributes
        System.out.println(this.name);
        System.out.println(this.register);
        System.out.println(this.rg);
        System.out.println(this.cpf);
    }
}
