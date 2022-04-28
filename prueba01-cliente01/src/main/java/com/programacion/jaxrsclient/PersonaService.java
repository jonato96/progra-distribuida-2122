package com.programacion.jaxrsclient;

import com.programacion.entities.Persona;
import javax.ws.rs.core.Response;
import java.util.List;

public interface PersonaService {
    Response create(Persona persona);

    Persona findById(Integer id);

    List<Persona> findAll();

    Response update(Integer id, Persona persona);

    Response delete(Integer id);
}
