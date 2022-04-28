package com.programacion.servicios;

import org.springframework.stereotype.Component;


public class ServicioLogImpl implements ServicioLog{
    @Override
    public void log(String msg) {
        System.out.println("LOG "+msg);
    }
}
