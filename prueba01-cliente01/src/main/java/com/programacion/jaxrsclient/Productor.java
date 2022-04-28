package com.programacion.jaxrsclient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
@ApplicationScoped
public class Productor {
    @ApplicationScoped
    @Produces
    public Client getClient(){
        Client client = ClientBuilder.newClient();
        return client;
    }
}
