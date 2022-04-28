package com.programacion;

import com.mongodb.MongoClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

import java.awt.*;

@ApplicationScoped
public class HolaImpl implements Hola{

    @Inject
    private MongoClient db;

    @Override
    public String saludar() {
        String midb="sin mongo";
        if(db != null){
            System.out.println("Vas bien");
            midb = db.getDatabase("pruebas1").getName();
            Document mydoc = db.getDatabase("pruebas1").getCollection("usuarios").find().first();
            System.out.println(mydoc.toJson());
            System.out.println("Conectado");

        }
        return "Hola desde la implementacion "+midb;
    }
}
