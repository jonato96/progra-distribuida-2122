package com.programacion.actions;

import com.programacion.entidades.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

@Action(value="crearAction",results={@Result(name = "success",type = "redirectAction",params = {"actionName","listarAction"})})
public class CrearAction {

    @Inject
    private ServicioUsuario servicio;

    private String nombre;
    private String apellido;
    private String direccion;

    public String execute(){
        Usuario obj = new Usuario(nombre, apellido, direccion);
        servicio.crear(obj);
        return "success";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
