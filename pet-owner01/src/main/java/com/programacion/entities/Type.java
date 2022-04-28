package com.programacion.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "types")
@NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t ORDER BY t.id")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String name;
}
