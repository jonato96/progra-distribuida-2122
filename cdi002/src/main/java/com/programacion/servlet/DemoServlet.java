package com.programacion.servlet;

import com.programacion.servicios.Operaciones;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    @Inject
    private Operaciones op;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ServletContext ctx = req.getServletContext();
//        SeContainer container = (SeContainer) ctx.getAttribute("ccc");
//
//        //Buscamos el componente
//        Instance<Operaciones> servicio = container.select(Operaciones.class);
//
//        //Obtenemos el metodo
//        Operaciones op = servicio.get();
        int resultado = op.suma(2,2);
        System.out.println("El resultado de la suma es: "+resultado);

        PrintWriter p = resp.getWriter();
        resp.setContentType("text/html");
        p.println("Hola Servlet");
    }
}
