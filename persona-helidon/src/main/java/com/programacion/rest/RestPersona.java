package com.programacion.rest;

import com.programacion.db.Jairo;
import com.programacion.db.JairoDto;
import com.programacion.db.Persona;
import com.programacion.service.PersonaService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/personas")
public class RestPersona {

    @Inject
    private PersonaService servicio;

    @Inject
    @ConfigProperty(name = "injected.value")
    private String injectedValue;

    @Inject
    @ConfigProperty(name = "server.port")
    private Integer port;

    @Path("/injected")
    @GET
    public String getInjectedConfigValue() {
        return "Config value as Injected by CDI " + injectedValue;
    }
    @GET
    @Path("/hola")
    public String hola(){
        return "Hola desde mi querido Helidon "+port;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll(){
        return servicio.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona findById(@PathParam("id") Integer id){
        return servicio.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JairoDto dto){
        servicio.create(dtoToEntity(dto));
        return Response.status(Response.Status.CREATED).build();
    }

    public Jairo dtoToEntity(JairoDto dto){
        return new Jairo(dto.getNombre(), dto.getApellido(), dto.getChuloId());
    }
}
