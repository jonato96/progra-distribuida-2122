package com.programacion.service;

import com.programacion.db.TipoDireccion;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TipoDireccionServiceImpl implements TipoDireccionService{

    @Inject
    EntityManager em;

    @Override
    public List<TipoDireccion> findAll() {
        return em.createNamedQuery("TipoDireccion.findAll", TipoDireccion.class).getResultList();
    }

    @Override
    public TipoDireccion findById(Integer id) {
        return em.find(TipoDireccion.class, id);
    }
}
