package com.programacion.services;

import com.programacion.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> findAll();
    Persona findById(Integer id);
    void create(Persona obj);
    void delete(Integer id);
    void update(Integer id, Persona obj);

}
