package com.programacion.db;

import lombok.Data;

@Data
public class JairoDto {
    private String nombre;
    private String apellido;
    private Integer chuloId;
    private String nombreChulo;

    public JairoDto(String nombre, String apellido, Integer chuloId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.chuloId = chuloId;
    }
}
