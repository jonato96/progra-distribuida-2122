package com.programacion.service.implementation;

import com.programacion.dto.Pet;
import com.programacion.dto.Type;
import com.programacion.service.interfaces.ServiceType;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServiceTyeImp implements ServiceType {

    @PersistenceContext(name = "ownerPU")
    private EntityManager emp;

    @Override
    public List<Type> listar() {
        return emp.createQuery("SELECT u FROM Type u", Type.class).getResultList();
    }

    @Override
    public Type listarPorId(Integer id) {
        return emp.find(Type.class, id);
    }
}
