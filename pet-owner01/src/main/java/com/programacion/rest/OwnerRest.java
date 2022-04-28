package com.programacion.rest;

import com.programacion.entities.Owner;
import com.programacion.interfaces.OwnerService;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("owners")
public class OwnerRest {
    @Inject
    private OwnerService srv;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner findById(@PathParam("id") Integer id){
        return srv.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Owner> findAll(){
        return srv.findAll();
    }
}
