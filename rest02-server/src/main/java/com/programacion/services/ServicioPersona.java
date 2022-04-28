package com.programacion.services;

import com.programacion.db.Persona;

import java.util.List;

public interface ServicioPersona {
    void create(Persona obj);
    Persona findById(Integer id);
    List<Persona> findAll();
    void update(Integer id, Persona obj);
    void delete(Integer id);
}
