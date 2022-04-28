package com.programacion.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(name = "name")
    private String nombre;

    //@Getter @Setter
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@JoinTable(name = "pets",
    //        joinColumns = @JoinColumn(name = "type_id"),
    //        inverseJoinColumns = @JoinColumn(name = "id"))
    //private List<Visit> visits;

}
