package com.programacion.servicios;



import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class LogProducer {
    //Anotamos el metodo y el ambito
    @Produces
    @ApplicationScoped
    public LogImpl createLog(){
        System.out.println("Productor");
        return new LogImpl();
    }
}
