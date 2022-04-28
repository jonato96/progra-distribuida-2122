package com.programacion.service.implementation;

import com.programacion.dto.Owner;
import com.programacion.dto.Pet;
import com.programacion.service.interfaces.ServicePet;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServicePetImp implements ServicePet {

    @PersistenceContext(name = "ownerPU")
    private EntityManager emp;

    @Override
    public List<Pet> listar() {
        return emp.createQuery("SELECT u FROM Pet u", Pet.class).getResultList();
    }

    @Override
    public Pet listarPorId(Integer id) {
        return emp.find(Pet.class, id);
    }
}
