package com.programacion.entities;

import lombok.*;

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
