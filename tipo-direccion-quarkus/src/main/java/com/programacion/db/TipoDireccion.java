package com.programacion.db;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipo_direccion")
@NamedQuery(name = "TipoDireccion.findAll", query = "SELECT d from TipoDireccion d order by d.id")
public class TipoDireccion {
    @Id
    private Integer id;
    @Column
    private String descripcion;
}
