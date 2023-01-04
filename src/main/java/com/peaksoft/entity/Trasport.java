package com.peaksoft.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "Transports")

public class Trasport {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column  (name = "name")
    private String name;
    private LocalDate date;
}
