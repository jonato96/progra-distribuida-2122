package com.programacion.rest;

import com.programacion.entities.Type;
import com.programacion.interfaces.TypeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/types")
public class TypeRest {
    @Inject
    private TypeService srv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Type> findAll(){
        return srv.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Type findById(@PathParam("id") Integer id){
        return srv.findById(id);
    }
}
