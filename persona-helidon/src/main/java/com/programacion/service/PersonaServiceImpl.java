package com.programacion.service;

import com.programacion.db.Persona;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
public class PersonaServiceImpl implements PersonaService{

    @PersistenceContext(name = "persona")
    private EntityManager em;

    @Override
    public List<Persona> findAll() {
        return em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
    }

    @Override
    public Persona findById(Integer id) {
        return em.find(Persona.class, id);
    }

    @Override
    public void create(Persona persona) {


    }

    @Override
    public void update(Persona persona, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
