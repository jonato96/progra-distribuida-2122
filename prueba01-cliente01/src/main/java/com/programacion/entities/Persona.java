package com.programacion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Persona implements Serializable {
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String direccion;
}
