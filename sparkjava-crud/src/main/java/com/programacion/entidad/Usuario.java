package com.programacion.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String correo;


}
