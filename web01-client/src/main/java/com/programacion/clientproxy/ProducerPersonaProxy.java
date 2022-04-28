package com.programacion.clientproxy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@RequestScoped
public class ProducerPersonaProxy {

    @Inject
    String urlServicio;

    @RequestScoped
    @Produces
    public PersonaProxy produceProxyPersona() {
        ResteasyClient cliente = (ResteasyClient) ResteasyClientBuilder.newBuilder().build();

        System.out.println(urlServicio);
        ResteasyWebTarget target = cliente.target(urlServicio);

        return target.proxy(PersonaProxy.class);
    }
}

