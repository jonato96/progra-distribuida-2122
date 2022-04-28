package com.programacion.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(name = "first_name")
    private String nombre;

    @Getter @Setter
    @Column(name = "last_name")
    private String apellido;

    @Getter @Setter
    @Column(name = "address")
    private String direccion;

    @Getter @Setter
    @Column(name = "city")
    private String ciudad;

    @Getter @Setter
    @Column(name = "telephone")
    private String telefono;

    //@Getter @Setter
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@JoinTable(name = "pets",
    //        joinColumns = @JoinColumn(name = "owner_id"),
    //        inverseJoinColumns = @JoinColumn(name = "id"))
    //private List<Pet> pets;

}
