package com.peaksoft.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private LocalDate date;

    public Laptop() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
