package com.programacion.apachecxf;

import com.programacion.entities.Persona;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PersonaService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Persona> findAll();

    @Path("/{id}")
    @GET
    Persona findById(@PathParam("id") Integer id);

    @POST
    Response create(Persona obj);

    @PUT
    @Path("/{id}")
    Response update(@PathParam("id") Integer id,Persona p);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") Integer id);
}
