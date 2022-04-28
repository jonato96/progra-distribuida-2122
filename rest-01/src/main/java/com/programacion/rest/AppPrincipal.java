package com.programacion.rest;

import com.google.gson.Gson;
import com.programacion.Persona;
import com.programacion.ServicioPersona;
import static spark.Spark.*;

public class AppPrincipal {

    /**
     * GET /personas
     * GET /personas/{id}
     * DELETE /personas{id}
     * PUT /personas{id}
     * POST /personas
     */

    public static void main (String[] args){
        final Gson gson = new Gson();
        final ServicioPersona servicio = new ServicioPersona();

        port(8080);

        get("/personas", (req,res)->{
            res.type("application/json");
            return gson.toJson(servicio.findAll());
        });

        get("/personas/:id", (req,res)->{
            res.type("application/json");
            Persona p = servicio.findById(Integer.valueOf(req.params("id")));
            if(p == null){
                res.status(404);
                return "no encontrado";
            }
            return gson.toJson(p);
        });

        delete("/personas/:id", (req, res)->{
            res.type("application/json");
            String _id = req.params("id");
            servicio.delete(Integer.valueOf(_id));
            res.status(200);
            return "Personas eliminada";
        });

        post("/personas", (req, res)->{
            String body = req.body();
            Persona p = gson.fromJson(body, Persona.class);
            servicio.create(p);
            res.status(201);
            res.header("location", "/personas/" + p.getId());
            return "creado";
        });

        put("/personas/:id", (req, res)->{
            String body = req.body();
            Persona p = gson.fromJson(body, Persona.class);
            servicio.update(Integer.valueOf(req.params("id")),p);
            res.status(200);
            return "modificado";
        });


    }
}
