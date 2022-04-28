package com.programacion.rest;

import com.programacion.entities.Visit;
import com.programacion.interfaces.VisitService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/visits")
public class VisitRest {
    @Inject
    private VisitService srv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Visit> findAll(){
        return srv.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Visit findById(@PathParam("id") Integer id){
        return srv.findById(id);
    }
}
