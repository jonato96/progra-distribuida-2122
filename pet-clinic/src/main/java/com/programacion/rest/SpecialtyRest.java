package com.programacion.rest;

import com.programacion.dto.Specialty;
import com.programacion.service.interfaces.ServiceSpecialty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/specialties")
public class SpecialtyRest {

    @Inject
    private ServiceSpecialty servicio;

    //especialidades
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Specialty> todos(){
        return servicio.listar();
    }

    //espec por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Specialty listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

}
