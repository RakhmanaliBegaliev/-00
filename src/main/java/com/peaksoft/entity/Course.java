package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "employee_company",
    joinColumns = @JoinColumn (name = "course_id"),
    inverseJoinColumns = @JoinColumn (name = "employees_id"))
    private List<Employee> employees;
}
