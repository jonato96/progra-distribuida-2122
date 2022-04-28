package com.programacion.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pets")
@NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p ORDER BY p.id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @Column(name = "birth_date")
    @Getter @Setter
    private LocalDate birthDate;

    @Getter @Setter
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Getter @Setter
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Getter @Setter
    private Type type;
}
