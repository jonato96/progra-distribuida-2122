package com.programacion.web;

import com.programacion.dto.Persona;
import com.programacion.servicios.ServicioPersona;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("indexBean")
@SessionScoped
public class IndexBean implements Serializable {

    @Inject
    private ServicioPersona servicio;

    @Getter private Integer contador = 1;
    @Getter private List<Persona> personas;
    @Getter
    @Setter private Persona persona;

    public String contar(){
        contador++;
        return "";
    }

    @PostConstruct
    void inicializar() throws Exception{
        persona = new Persona();
        personas =  servicio.findAll();
    }

    public void create() throws Exception {
        servicio.create(persona);
        persona = new Persona();
        personas = servicio.findAll();
    }

    public String edit(Integer id){
        persona = servicio.findById(id);
        return "/update.xhtml?faces-redirect=true";
    }

    public String update(Persona obj){
        servicio.update(obj.getId(), obj);
        personas = servicio.findAll();
        return "/index.xhtml?faces-redirect=true";
    }

    public void delete(Integer id){
        servicio.delete(id);
        personas = servicio.findAll();
    }

}
