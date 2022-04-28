package com.programacion.db;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.id")
public class Persona {
    @Id
    private Integer id;
    @Column
    private String cedula;
    @Column
    private String direccion;
    @JoinColumn(name = "tipo_direccion")
    @OneToOne
    private TipoDireccion tipoDireccion;
    @Column
    private String nombre;
}
