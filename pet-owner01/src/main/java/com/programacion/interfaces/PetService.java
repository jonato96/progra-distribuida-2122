package com.programacion.interfaces;

import com.programacion.entities.Pet;

import java.util.List;

public interface PetService {
    List<Pet> findAll();
    Pet findById(Integer id);
}
