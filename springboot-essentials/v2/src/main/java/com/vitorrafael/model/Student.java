package com.vitorrafael.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity // Map Student class to a table
public class Student extends AbstractEntity {

    @NotEmpty // Make the following attribute mandatory
    private String name;

    @Email
    @NotEmpty(message = "Field Email must not be empty") // Customize error message
    private String email;

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
