package com.programacion.rest;

import com.programacion.entities.Persona;
import com.programacion.services.PersonaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/personas")
public class PersonaRest {

    @Inject
    private PersonaService servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll(){
        return servicio.findAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Persona findById(@PathParam("id") Integer id){
        return servicio.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Persona obj){
        servicio.create(obj);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id,Persona p){
        servicio.update(p.getId(),p);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id){
        servicio.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
