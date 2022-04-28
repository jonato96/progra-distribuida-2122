package com.programacion.actions;

import com.programacion.entidades.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

@Action(value="actualizarAction",results={@Result(name = "success",type = "redirectAction",params = {"actionName","listarAction"})})
public class ActualizarAction {

    @Inject
    private ServicioUsuario servicio;

    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Usuario obj;

    public String execute(){

        obj = new Usuario(id,nombre, apellido, direccion);
        System.out.println(obj.toString());
        servicio.editar(obj);

        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
