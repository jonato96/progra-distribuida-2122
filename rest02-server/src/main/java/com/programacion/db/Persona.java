package com.programacion.db;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String direccion;
}
