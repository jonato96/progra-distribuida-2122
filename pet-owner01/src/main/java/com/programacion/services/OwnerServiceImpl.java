package com.programacion.services;

import com.programacion.entities.Owner;
import com.programacion.interfaces.OwnerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;
import java.util.List;
@ApplicationScoped
public class OwnerServiceImpl implements OwnerService {
    @Inject
    EntityManager em;

    @Override
    public Owner findById(Integer id) {
        return em.find(Owner.class, id);
    }

    @Override
    public List<Owner> findAll() {
        TypedQuery<Owner> query = em.createQuery(
                "SELECT e FROM Owner e", Owner.class);
        return query.getResultList();
        //return em.createNamedQuery("Owner.findAll", Owner.class).getResultList();
    }
}
