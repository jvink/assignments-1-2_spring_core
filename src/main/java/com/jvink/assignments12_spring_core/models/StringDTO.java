package com.jvink.assignments12_spring_core.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StringDTO {
    @Id
    private String name;
    private Number count;

    public StringDTO() {}

    public StringDTO(String name, Number count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Number getCount() {
        return count;
    }
}