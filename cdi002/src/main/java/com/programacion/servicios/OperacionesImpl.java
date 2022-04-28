package com.programacion.servicios;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OperacionesImpl implements Operaciones{
    @Inject
    private Log log;

    public OperacionesImpl(){
        System.out.println("Estoy en el constructor");
    }

    @PostConstruct
    void init(){
        System.out.println("Ciclo de vida @PostConstruc");
    }
    @PreDestroy
    void destroy(){
        System.out.println("Ciclo de vida @PreDestroy");
    }

    public int suma(int x, int y) {
        log.log("Inicializando operacion");
        return x+y;
    }
}
