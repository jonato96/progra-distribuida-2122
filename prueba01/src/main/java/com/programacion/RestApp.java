package com.programacion;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.programacion.config.EntityManagerProducer;
import com.programacion.rest.PersonaRest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApp extends Application {

}