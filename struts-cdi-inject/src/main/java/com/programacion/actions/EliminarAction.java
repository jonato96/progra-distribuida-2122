package com.programacion.actions;

import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

@Action(value="eliminarAction",results={@Result(name = "success",type = "redirectAction",params = {"actionName","listarAction"})})
public class EliminarAction {

    @Inject
    private ServicioUsuario servicio;
    private int id;

    public String execute(){
        servicio.eliminar(id);
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
