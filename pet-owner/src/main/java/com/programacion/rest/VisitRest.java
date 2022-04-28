package com.programacion.rest;

import com.programacion.dto.Pet;
import com.programacion.dto.Visit;
import com.programacion.service.interfaces.ServiceVisit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/visits")
public class VisitRest {

    @Inject
    private ServiceVisit servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Visit> todos(){
        return servicio.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Visit listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
