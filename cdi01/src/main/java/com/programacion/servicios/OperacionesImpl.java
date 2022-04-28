package com.programacion.servicios;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OperacionesImpl implements Operaciones{

    //DI
    @Inject
    private ServicioLog log;

    public OperacionesImpl(){
        System.out.println("***OperacionesIMP Contructor***");
    }
    @PostConstruct
    void init(){
        log.log("Ciclo de vida @PostConstruct");
    }

    @PreDestroy
    void destroy(){
        log.log("Ciclo de vida @PreDestroy");
    }

    @Override
    public int sumar(int x, int y) {
        log.log("Sumando los numeros");
        return x+y;
    }
}
