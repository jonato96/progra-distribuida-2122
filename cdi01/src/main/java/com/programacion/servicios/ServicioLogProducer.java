package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ServicioLogProducer {
    //El productor son componentes sin interfaz
    @ApplicationScoped
    @Produces
    public ServicioLog createLog(){
        System.out.println("PRODUCTOR ServicioLogProducer");
        return new ServicioLogImpl();
    }
}
