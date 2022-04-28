package com.programacion;

import com.programacion.servicios.Operaciones;
import com.programacion.servicios.ServicioLog;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Principal {
    public static void main(String[] args) {
        //LOOKUP

        //Crear la instancia del contenedor
        SeContainer container = SeContainerInitializer
                .newInstance()
                .initialize();

        //Buscar un componente
        Instance<Operaciones> obj = container.select(Operaciones.class);
        Operaciones servicio = obj.get();
        System.out.println(servicio.getClass());

        //Invocar el metodo
        int ret = servicio.sumar(5,9);
        System.out.printf("El resultado es: %d\n", ret);

        ServicioLog log = container.select(ServicioLog.class).get();
        log.log("Fin");

    }
}
