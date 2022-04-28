package com.programacion.service.interfaces;

import com.programacion.dto.Specialty;

import java.util.List;

public interface ServiceSpecialty {

    List<Specialty> listar();
    Specialty listarPorId(Integer id);

}
