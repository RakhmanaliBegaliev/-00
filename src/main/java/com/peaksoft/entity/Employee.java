package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name", unique = true, length = 40)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "company_id")
    private Company company;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "employees")
    List<Course>courses;
    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
