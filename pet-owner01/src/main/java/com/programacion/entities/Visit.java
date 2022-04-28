package com.programacion.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v ORDER BY v.id")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Column(name = "visit_date")
    @Getter @Setter
    private LocalDate visitDate;

    @Getter @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @Getter @Setter
    private Pet pet;
}
