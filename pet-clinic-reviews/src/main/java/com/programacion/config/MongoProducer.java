package com.programacion.config;

import com.mongodb.ConnectionString;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MongoProducer {
    @ApplicationScoped
    @Produces
    public MongoDatabase getMongo(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:adminPRO96@cluster0.kxm9l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("practica");
        return mongoDatabase;

        //mongodb+srv://admin:<password>@cluster0.kxm9l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority
//        String url = "localhost";
//        int port = 27017;
        //return new MongoClient(url, port);
    }
}
