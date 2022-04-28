package com.programacion.services;

import com.programacion.entities.Pet;
import com.programacion.interfaces.PetService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PetServiceImpl implements PetService {

    @Inject
    EntityManager em;

    @Override
    public List<Pet> findAll() {
        return em.createNamedQuery("Pet.findAll",Pet.class).getResultList();
    }

    @Override
    public Pet findById(Integer id) {
        return em.find(Pet.class, id);
    }
}
