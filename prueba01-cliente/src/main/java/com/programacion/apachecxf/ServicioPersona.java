package com.programacion.apachecxf;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.programacion.entities.Persona;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ServicioPersona {

  @Inject
  ServicioPersona proxy;

    public List<Persona> findAll() {

        return proxy.findAll();
    }


    public Persona findById(Integer id) {

        return proxy.findById(id);
    }


    public Response create(Persona obj) {

        proxy.create(obj);
        return Response.status(Response.Status.CREATED).build();
    }


    public Response update(Integer id, Persona p) {


        proxy.update(id, p);
        return Response.status(Response.Status.OK).build();

    }


    public Response delete(Integer id) {

        proxy.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
