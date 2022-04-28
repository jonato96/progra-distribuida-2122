package com.programacion;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/personas")
public class PersonasServlet extends HttpServlet {

    private ServicioPersona servicio = new ServicioPersona();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter p = resp.getWriter();
//        Persona obj = servicio.findById(1);
//        p.println("Mi objeto persona: "+ obj.getNombre()+" "+obj.getDireccion());
//
//        p.println("Listado");
//        List<Persona> datos = servicio.findAll();
//        datos.forEach(persona -> p.println(persona.getNombre()+" "+persona.getDireccion()));

        List<Persona> datos = servicio.findAll();

        Gson gson = new Gson();

        resp.setContentType("application/json");

        String texto = gson.toJson(datos);

        p.println(texto);




    }
}
