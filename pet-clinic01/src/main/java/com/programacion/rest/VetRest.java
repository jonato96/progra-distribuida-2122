package com.programacion.rest;

import com.programacion.entiites.Specialty;
import com.programacion.services.SpecialtyService;

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
    private SpecialtyService srv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Specialty> findAll(){
        return srv.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Specialty findById(@PathParam("id") Integer id){
        return srv.findById(id);
    }
}
