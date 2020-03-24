package com.vitorrafael.model;

import javax.persistence.Entity;

@Entity // Map Student class to a table
public class Student extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
