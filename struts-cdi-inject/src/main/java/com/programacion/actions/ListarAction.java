package com.programacion.actions;

import com.programacion.entidades.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

@Action(value="listarAction",results={@Result(name="success",location="/result.jsp")})
public class ListarAction {

    @Inject
    private ServicioUsuario servicio;

    private List<Usuario> listado;
    private String nombre;
    private String apellido;
    private String direccion;

    public String execute(){
        listado = servicio.buscarTodos();
        return "success";
    }

    public List<Usuario> getListado() {
        return listado;
    }

    public void setListado(List<Usuario> listado) {
        this.listado = listado;
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
