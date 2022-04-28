package com.programacion.db;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tipo_direccion")
public class TipoDireccion {
    @Id
    private Integer id;
    @Column
    private String descripcion;
}
