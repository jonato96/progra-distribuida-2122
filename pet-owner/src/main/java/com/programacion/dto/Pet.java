package com.programacion.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(name = "birth_date")
    private String fechaNacimiento;

    @Getter @Setter
    @Column(name = "date")
    private LocalDate fecha;

    @Getter @Setter
    @Column(name = "owner_id")
    private Integer idOwner;

//    @Getter @Setter
//    @Column(name = "type_id")
//    private Integer idType;

    @Getter @Setter
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id")
    private Type types;

    //@Getter @Setter
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@JoinTable(name = "visits",
    //        joinColumns = @JoinColumn(name = "pet_id"),
    //        inverseJoinColumns = @JoinColumn(name = "id"))
    //private List<Visit> visits;

}
