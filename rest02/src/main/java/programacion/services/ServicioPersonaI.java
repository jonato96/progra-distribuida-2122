package programacion.services;

import programacion.db.Persona;

import java.util.ArrayList;
import java.util.List;

public interface ServicioPersonaI {

    Persona findById(Integer id);

    List<Persona> findAll();

    void delete(Integer id);

    void update(Integer id, Persona obj);

    void create(Persona p);

}
