package com.programacion.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(name = "visit_date")
    private String fecha;

    @Getter @Setter
    @Column(name = "descripcion")
    private String descripcion;

//    @Getter @Setter
//    @Column(name = "pet_id")
//    private Integer idPet;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pet_id")
    private Pet pets;

}
