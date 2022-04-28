package com.programacion.bean;

import com.programacion.entities.Persona;
import com.programacion.jaxrsclient.PersonaService;
import com.programacion.jaxrsclient.PersonaServiceImpl;
import com.programacion.proxyclient.PersonasRestProxy;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("indexBean")
@SessionScoped
public class PersonaBean implements Serializable {

    @Inject
    //private PersonaService servicio;
    private PersonasRestProxy servicio;

    @Getter
    @Setter
    Persona persona;

    @Getter
    @Setter
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

    public String create() throws Exception {
        System.out.println(persona.toString());
        servicio.create(persona);
        personas = servicio.findAll();
        return retorno();
    }

    public String edit(Integer id){
        persona = servicio.findById(id);
        return "/update.xhtml?faces-redirect=true";
    }

    public String update(Persona obj){
        servicio.update(obj.getId(), obj);
        personas = servicio.findAll();
        return retorno();
    }

    public void delete(Integer id){
        servicio.delete(id);
        personas = servicio.findAll();
    }

}
