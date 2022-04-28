package com.programacion.web;

import com.programacion.dto.Persona;
import com.programacion.clientproxy.PersonaProxy;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("personaBean")
@SessionScoped
public class PersonaBean implements Serializable {
    //jaxrs client
    //@Inject
    //private ServicioPersona servicio;

    //proxy client
    @Inject
    private PersonaProxy servicio;

    @Getter
    @Setter
    Persona persona;

    @Getter
    List<Persona> personas;

    @PostConstruct
    public void inicializer(){
        System.out.println("Inicializando");
        persona = new Persona();
        personas = servicio.findAll();
    }

    public String retorno(){
        persona = new Persona();
        return "/index.xhtml?faces-redirect=true";
    }

    public String create(){
        System.out.println(persona.toString());
        servicio.create(persona);
        personas = servicio.findAll();
        return retorno();
    }

    public String edit(Integer id){
        persona = servicio.findById(id);
        return "/update.xhtml?faces-redirect=true";
    }

    public String update(){
        servicio.update(persona.getId(), persona);
        personas = servicio.findAll();
        return retorno();
    }

    public void delete(Integer id){
        servicio.delete(id);
        personas = servicio.findAll();
    }

}
