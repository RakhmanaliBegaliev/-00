package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 40)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Employee> employees;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transport")
    private List<Transport>transports;
    public void addEmployeeToCompany(Employee e){
        if (employees==null){
            employees=new ArrayList<>();
        }employees.add(e);
        e.setCompany(this);
    }
    public void addTransportToCompany(Transport t){
        if (transports==null){
            transports=new ArrayList<>();
        }transports.add(t);
        t.setCompany(this);
    }
}



