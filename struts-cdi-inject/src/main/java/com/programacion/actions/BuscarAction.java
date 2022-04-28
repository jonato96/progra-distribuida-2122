package com.programacion.actions;

import com.programacion.entidades.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

@Action(value = "buscarAction", results = {@Result(name = "success", location = "/update.jsp")})
public class BuscarAction {

    @Inject
    private ServicioUsuario servicio;

    private int id;
    private Usuario obj;

    public Usuario getObj() {
        return obj;
    }

    public void setObj(Usuario obj) {
        this.obj = obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {
        obj = servicio.buscar(id);
        return "success";
    }
}
