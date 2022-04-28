package com.programacion.service.implementation;

import com.programacion.dto.Visit;
import com.programacion.service.interfaces.ServiceVisit;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServiceVisitImp implements ServiceVisit {

    @PersistenceContext(name = "ownerPU")
    private EntityManager emp;

    @Override
    public List<Visit> listar() {
        return emp.createQuery("SELECT U FROM Visit U", Visit.class).getResultList();
    }

    @Override
    public Visit listarPorId(Integer id) {
        return emp.find(Visit.class, id);
    }
}
