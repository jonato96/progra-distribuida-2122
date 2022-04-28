package com.programacion.rest;


import com.programacion.dto.Vet;
import com.programacion.service.interfaces.ServiceVet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/vets")
public class VetRest {

    @Inject
    private ServiceVet servicio;

    //todos los vet
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vet> todos(){
        return  servicio.listar();
    }

    //vets por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vet listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
