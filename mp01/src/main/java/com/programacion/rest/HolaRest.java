package com.programacion.rest;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@ApplicationScoped
@Path("/hola")
public class HolaRest {

    //forma generica
    //@Inject
    //private Config config;
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    private Integer port;

    @ConfigProperty(name="mensaje")
    private String  mensaje;


    @GET
    public String hola(){
        System.out.println("Fuentes de configuracion");
        ConfigProvider.getConfig().getConfigSources()
                .forEach(s->{
                    System.out.printf("%3d: %s\n", s.getOrdinal(), s.getName());
                });
        //opcion1
        //String msg = config.getValue("mensaje", String.class);

        //return String.format("%s %s", mensaje, LocalDateTime.now())+" "+port;
        return mensaje +" "+port;
    }
}
