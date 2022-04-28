package com.programacion.servicios;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperacionesImpl implements Operaciones{

    @Override
    public int suma(int x, int y) {
        System.out.println("Sumando "+x+" y "+y);
        return x+y;
    }
}
