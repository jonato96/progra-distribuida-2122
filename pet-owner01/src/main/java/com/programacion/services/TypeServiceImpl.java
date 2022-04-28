package com.programacion.services;

import com.programacion.entities.Type;
import com.programacion.entities.Visit;
import com.programacion.interfaces.TypeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TypeServiceImpl implements TypeService {

    @Inject
    private EntityManager em;

    @Override
    public List<Type> findAll() {
        return em.createNamedQuery("Type.findAll", Type.class).getResultList();
    }

    @Override
    public Type findById(Integer id) {
        return em.find(Type.class, id);
    }
}
