package com.programacion.services;

import com.programacion.entities.Visit;
import com.programacion.interfaces.VisitService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VisitServiceImpl implements VisitService {
    @Inject
    private EntityManager em;

    @Override
    public List<Visit> findAll() {
        return em.createNamedQuery("Visit.findAll", Visit.class).getResultList();
    }

    @Override
    public Visit findById(Integer id) {
        return em.find(Visit.class, id);
    }
}
