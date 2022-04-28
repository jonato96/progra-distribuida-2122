package com.programacion;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.literal.NamedLiteral;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import servicios.HolaMundo;

public class Principal {
    public static void main(String[] args) {

        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Instance<HolaMundo> servicio = container.select(HolaMundo.class, NamedLiteral.of("miBean"));
        HolaMundo miServicio = servicio.get();
        String cadena = miServicio.hola("Jonathan");
        System.out.println(cadena);

    }
}
