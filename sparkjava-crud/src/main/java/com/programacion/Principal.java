package com.programacion;
import com.google.gson.Gson;
import com.programacion.entidad.Usuario;
import com.programacion.servicio.ServicioUsuario;
import com.programacion.servicio.ServicioUsuarioImpl;

import java.util.List;

import static spark.Spark.*;

public class Principal {
    public static void main (String[] args){

        ServicioUsuario servicio = new ServicioUsuarioImpl();
        Gson gson = new Gson();

        //Asignamos el puerto
        port(8080);

        //verbo, path, callback
        get("/hola", (request, reponse) -> {
           return "Hola mundo mi pez";
        });

        get("/usuarios", (req, res) -> {
           res.type("application/json");
            List<Usuario> misObjs = servicio.findAll();
            if(misObjs == null ){
                res.status(404);
                return "No hay usuarios en el mapa";
            }
           return new Gson().toJsonTree(misObjs);
        });

        get("/usuario/:id", (req,res) -> {
           res.type("application/json");
           Usuario obj = servicio.find(Integer.valueOf(req.params("id")));
           if(obj == null ){
               res.status(404);
               return "Usuario no encontrado";
           }
           String miUsuarioJson = new Gson().toJson(obj);
           return miUsuarioJson;
        });

        post("/usuario", (req, res) -> {
            Usuario miUser = new Gson().fromJson(req.body(), Usuario.class);
            servicio.create(miUser);
            return "Crear un usuario";
        });

        put("/usuario/:id", (req, res) -> {
            Usuario miUser = new Gson().fromJson(req.body(), Usuario.class);
            servicio.update(miUser);
            return "Editar un usuario";
        });

        delete("/usuario/:id", (req, res) -> {
            servicio.delete(Integer.valueOf(req.params("id")));
            res.status(204);
            return "Usuario eliminado "+req.params("id");
        });

    }
}
