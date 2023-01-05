package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "passports")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pass_qen", sequenceName = "seq_qen", allocationSize = 5)
    private Long id;
    @Column(unique = true, nullable = true, length = 40)
    private String INN;
    @OneToOne(mappedBy = "passport")
    private Employee employee;

}
