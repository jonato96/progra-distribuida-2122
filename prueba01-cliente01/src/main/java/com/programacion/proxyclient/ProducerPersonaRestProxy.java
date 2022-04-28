package com.programacion.proxyclient;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class ProducerPersonaRestProxy {

    public static final String URL = "http://localhost:8080/prueba01";

    @RequestScoped
    @Produces
    public PersonasRestProxy produceProxyPersona() {
        ResteasyClient cliente = (ResteasyClient) ResteasyClientBuilder.newBuilder().build();

        ResteasyWebTarget target = cliente.target(URL);

        return target.proxy(PersonasRestProxy.class);
    }

}
