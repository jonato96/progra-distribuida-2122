package com.programacion.servlet;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class DemoListener implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("*************Invocandose*********************");
//        //Inicializamos el contenedor
//        SeContainer container = SeContainerInitializer
//                .newInstance()
//                .initialize();
//        ServletContext ctx = sce.getServletContext();
//                ctx.setAttribute("ccc", container);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//
//    }
}
