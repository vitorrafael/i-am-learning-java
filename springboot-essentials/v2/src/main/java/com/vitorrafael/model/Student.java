package com.vitorrafael.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity // Map Student class to a table
public class Student extends AbstractEntity {

   // @NotEmpty  -> Make the following attribute mandatory
    @NotEmpty(message = "Field  name must not be empty") // Customize error message
    private String name;

    @Email(message = "Email not valid")
    @NotEmpty(message = "Field email must not be empty")
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
