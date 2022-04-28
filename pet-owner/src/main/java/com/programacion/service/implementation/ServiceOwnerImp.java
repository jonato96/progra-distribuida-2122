package com.programacion.service.implementation;

import com.programacion.dto.Owner;
import com.programacion.service.interfaces.ServiceOwner;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServiceOwnerImp implements ServiceOwner {

    @PersistenceContext(name = "ownerPU")
    private EntityManager emp;

    @Override
    public List<Owner> listar() {
        return emp.createQuery("SELECT u FROM Owner u", Owner.class).getResultList();
    }

    @Override
    public Owner listarPorId(Integer id) {
        return emp.find(Owner.class, id);
    }

}
