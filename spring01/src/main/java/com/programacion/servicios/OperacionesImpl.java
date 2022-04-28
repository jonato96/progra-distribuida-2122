package com.programacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperacionesImpl implements Operaciones{

    //DI
    @Autowired
    private ServicioLog log;

    @Override
    public int sumar(int x, int y) {
        log.log("Sumando los numeros");
        return x+y;
    }
}
