package com.programacion.servicios;

import com.programacion.dto.Persona;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class ServicioPersona {

    private static final String URL = "http://localhost:8080/rest02/personas";

    public void create(Persona persona) throws Exception{
        Client client = ClientBuilder.newClient();
        Entity<Persona> entity = Entity.entity(persona, MediaType.APPLICATION_JSON);
        Response response = client.target(URL)
                .request()
                .post(entity);
        if(response.getStatus() == Response.Status.CREATED.getStatusCode()){
            System.out.println("Creado "+response.getStatus());
        }else{
            System.out.println("Error al crear "+response.getStatus());
        }
    }

    public List<Persona> findAll(){
        Client client = ClientBuilder.newClient();
        return client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Persona>>(){});
    }

    public Persona findById(Integer id){
        Client client = ClientBuilder.newClient();
        return client.target(URL)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .get(Persona.class);
    }

    public void update(Integer id, Persona persona){
        Client client = ClientBuilder.newClient();
        Entity<Persona> entity = Entity.entity(persona, MediaType.APPLICATION_JSON);
        Response response = client.target(URL)
                .path(id.toString())
                .request()
                .put(entity);
        if(response.getStatus() == Response.Status.OK.getStatusCode()){
            System.out.println("Modificado "+response.getStatus());
        }else{
            System.out.println("Error al modificar "+response.getStatus());
        }
    }

    public void delete(Integer id){
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL)
                .path(id.toString())
                .request()
                .delete();
        if(response.getStatus() == Response.Status.OK.getStatusCode()){
            System.out.println("ELiminado con exito");
        }else{
            System.out.println("Error, contacte al admin");
        }
    }
}
