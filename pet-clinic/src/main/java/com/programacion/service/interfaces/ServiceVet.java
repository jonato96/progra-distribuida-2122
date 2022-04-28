package com.programacion.service.interfaces;

import com.programacion.dto.Vet;

import java.util.List;

public interface ServiceVet {

    List<Vet> listar();
    Vet listarPorId(Integer id);

}
