package com.programacion.rest;

import com.programacion.dto.Owner;
import com.programacion.service.interfaces.ServiceOwner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/owners")
public class OwnerRest {

    @Inject
    private ServiceOwner servicio;

    //duenos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Owner> todos(){
        return servicio.listar();
    }

    //duenos por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
