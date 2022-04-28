package com.programacion.rest;

import com.programacion.entities.Pet;
import com.programacion.interfaces.PetService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("pets")
public class PetRest {
    @Inject
    private PetService srv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pet> findAll(){
        return srv.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pet findById(@PathParam("id") Integer id){
        return srv.findById(id);
    }
}
