package com.programacion.services;

import com.programacion.entities.Persona;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PersonaServiceImpl implements PersonaService{

    @Inject
    private EntityManager em;

    @Override
    public Persona findById(Integer id) {
        return em.find(Persona.class,id);
    }

    @Override
    public List<Persona> findAll() {
        String stringQuery = "SELECT e FROM Persona e ORDER BY e.id";
        TypedQuery<Persona> query = em.createQuery(
                stringQuery, Persona.class);
        return query.getResultList();
    }

    @Override
    public void create(Persona obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Persona obj) {
        em.getTransaction().begin();
        Persona p = em.find(Persona.class,id);
        p.setNombre(obj.getNombre());
        p.setDireccion(obj.getDireccion());
        em.merge(p);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        em.getTransaction().begin();
        Persona p = em.find(Persona.class,id);
        em.remove(p);
        em.getTransaction().commit();

    }
}
