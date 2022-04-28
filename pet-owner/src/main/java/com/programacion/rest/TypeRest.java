package com.programacion.rest;

import com.programacion.dto.Pet;
import com.programacion.dto.Type;
import com.programacion.service.interfaces.ServiceType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/types")
public class TypeRest {

    @Inject
    private ServiceType servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Type> todos(){
        return servicio.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Type listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
