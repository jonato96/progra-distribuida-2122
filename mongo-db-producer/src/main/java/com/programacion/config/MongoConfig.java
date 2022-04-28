package com.programacion.config;

import com.mongodb.MongoClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class MongoConfig {
    @ApplicationScoped
    @Produces
    public MongoClient mongoClient(){
        String url = "localhost";
        int port = 27017;
        MongoClient mongo = new MongoClient(url, port);
        return mongo;
    }
}
