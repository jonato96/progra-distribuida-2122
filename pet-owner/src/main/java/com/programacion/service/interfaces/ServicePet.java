package com.programacion.service.interfaces;

import com.programacion.dto.Pet;

import java.util.List;

public interface ServicePet {

    List<Pet> listar();
    Pet listarPorId(Integer id);

}
