package com.programacion.service;

import com.programacion.db.Persona;

import javax.ws.rs.core.Response;
import java.util.List;

public interface PersonaService {
    List<Persona> findAll();
    Persona findById(Integer id);
    void create(Persona persona);
    void update(Persona persona, Integer id);
    void delete(Integer id);
}
