package com.programacion.rest;

import com.programacion.dto.Owner;
import com.programacion.dto.Pet;
import com.programacion.service.interfaces.ServicePet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/pets")
public class PetRest {

    @Inject
    private ServicePet servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pet> todos(){
        return servicio.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pet listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
