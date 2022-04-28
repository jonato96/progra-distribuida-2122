package com.programacion.jaxrsclient;

import com.programacion.entities.Persona;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class PersonaServiceImpl implements PersonaService{

    private static final String URL = "http://localhost:8080/prueba01/personas";
    @Inject
    private Client client;

    public Response create(Persona persona){
        //Client client = ClientBuilder.newClient();
        Entity<Persona> entity = Entity.entity(persona, MediaType.APPLICATION_JSON);
        client.target(URL)
                .request()
                .post(entity);
        return Response.status(Response.Status.CREATED).build();
    }

    public Persona findById(Integer id){
        //Client client = ClientBuilder.newClient();
        Persona obj = client.target(URL+"/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Persona.class);
        return obj;
    }

    public List<Persona> findAll(){
        //Client client = ClientBuilder.newClient();
        Persona[] personas = client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .get(Persona[].class);
        return Arrays.asList(personas);
    }

    public Response update(Integer id, Persona persona){
        //Client client = ClientBuilder.newClient();
        Entity<Persona> entity = Entity.entity(persona, MediaType.APPLICATION_JSON);
        client.target(URL+"/"+id)
                .request()
                .put(entity);
        return Response.status(Response.Status.OK).build();
    }

    public Response delete(Integer id){
        //Client client = ClientBuilder.newClient();
        client.target(URL+"/"+id)
                .request()
                .delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
