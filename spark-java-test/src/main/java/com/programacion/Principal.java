package com.programacion;
import static spark.Spark.*;

public class Principal {
    public static void main ( String[] args ){

        //A verb (get, post, put, delete, head, trace, connect, options)
        //A path (/hello, /users/:name)
        //A callback (request, response) -> { }

        port(8080);

        get("/hola", (request, response) -> "Hola Mundo Spark");

        get("/nombre", (request, reponse) -> {
            return "Hola mi nombre es Jonathan";
        });
    }
}
