package com.programacion.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
    @ApplicationScoped
    @Produces
    public EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("openjpa", System.getProperties());
        return factory.createEntityManager();
    }


}
