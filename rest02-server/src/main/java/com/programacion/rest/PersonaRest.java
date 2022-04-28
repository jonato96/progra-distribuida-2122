package com.programacion.rest;

import com.programacion.db.Persona;
import com.programacion.services.ServicioPersona;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

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
    ServicioPersona servicio;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Persona obj){
        servicio.create(obj);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll(){
        List<Persona> personas =  servicio.findAll();
        return personas;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona findById(@PathParam("id") Integer id){
        Persona obj = servicio.findById(id);
        return obj;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Persona obj){
        servicio.update(id, obj);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        servicio.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}