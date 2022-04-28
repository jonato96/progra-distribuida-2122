package com.programacion.apachecxf;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Collections;
@ApplicationScoped
public class ProxyCxf {
    private static final String URL = "http://localhost:8080/prueba01";
    @ApplicationScoped
    @Produces
    public PersonaService getInstance(){
        PersonaService proxy = JAXRSClientFactory.create(URL, PersonaService.class,
                Collections.singletonList(new JacksonJsonProvider()));
        return proxy;
    }
}
