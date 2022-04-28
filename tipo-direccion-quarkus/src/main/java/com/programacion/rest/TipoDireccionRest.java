package com.programacion.rest;

import com.programacion.db.TipoDireccion;
import com.programacion.service.TipoDireccionService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/direcciones")
public class TipoDireccionRest {

    @Inject
    TipoDireccionService servicio;

    @ConfigProperty(name = "mensaje.config")
    String appName;

    @GET
    @Path("/hola")
    public String Saludos(){
        return "Salundando desde :" + appName;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoDireccion> findAll(){
        return servicio.findAll();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoDireccion findById(@PathParam("id") Integer id){
        return servicio.findById(id);
    }

}
