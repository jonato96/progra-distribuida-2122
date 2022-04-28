package com.programacion.proxyclient;

import com.programacion.entities.Persona;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
public interface PersonasRestProxy {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Persona findById(@PathParam("id") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Persona> findAll();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(Persona obj);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(@PathParam("id") Integer id, Persona obj);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response delete(@PathParam("id") Integer id);
}
