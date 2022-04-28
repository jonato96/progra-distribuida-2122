package com.programacion.apachecxf;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.programacion.entities.Persona;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;


public class PersonaServiceImpl implements PersonaService{

    private static final String URL = "http://localhost:8080/prueba01";

    @Override
    public List<Persona> findAll() {
        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
        //WebClient.client(proxy).accept(MediaType.APPLICATION_JSON);
        return proxy.findAll();
    }

    @Override
    public Persona findById(Integer id) {
        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
        //WebClient.client(proxy).accept(MediaType.APPLICATION_JSON);
        return proxy.findById(id);
    }

    @Override
    public Response create(Persona obj) {
        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
        //WebClient.client(proxy).type(MediaType.APPLICATION_JSON);
        //WebClient.client(proxy).accept(MediaType.APPLICATION_JSON);
        proxy.create(obj);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response update(Integer id, Persona p) {

        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
       // WebClient.client(proxy).accept(MediaType.APPLICATION_JSON);
        //WebClient.client(proxy).type(MediaType.APPLICATION_JSON);
        proxy.update(id, p);
        return Response.status(Response.Status.OK).build();

    }

    @Override
    public Response delete(Integer id) {
        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
        //WebClient.client(proxy).accept(MediaType.APPLICATION_JSON);
        proxy.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
