package com.programacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioPersona {

    private Map<Integer, Persona> personas = new HashMap<>();

    {
        Persona p = new Persona(1, "Jonathan", "Quininde");
        Persona p1 = new Persona(2, "Juan", "Lara");
        personas.put(p.getId(), p);
        personas.put(p1.getId(), p1);
    }

    public Persona findById(Integer id){
        return personas.get(id);
    }

    public List<Persona> findAll(){
        return new ArrayList<>(personas.values());
    }

    public void delete(Integer id){
        personas.remove(id);
    }

    public void update(Integer id, Persona obj){

        Persona p = personas.get(id);
        if(p != null){
            p.setNombre(obj.getNombre());
            p.setDireccion(obj.getDireccion());
        }
        personas.put(id, p);
    }

    public void create(Persona p){
        personas.put(p.getId(), p);
    }

}
