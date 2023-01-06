package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "animals")
@Getter
@Setter
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private int age;
    @OneToOne (cascade = CascadeType.REFRESH,mappedBy ="animal" )
    private Employee employee;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
