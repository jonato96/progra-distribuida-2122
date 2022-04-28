package com.programacion.action;

import com.programacion.db.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Action(value="registerAction",results={@Result(name="success",location="/result.jsp")})
public class RegisterAction {

    @Inject
    private ServicioUsuario listadoUser;

    private String nombre;
    private String apellido;
    private String direccion;

    private List<Usuario> listado;

    public String execute(){
        Usuario user = new Usuario();
        user.setApellido(apellido);
        user.setNombre(nombre);
        user.setDireccion(direccion);
        listado = new ArrayList<Usuario>();
        listado = listadoUser.usuarios();
        listado.add(user);
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

    public List<Usuario> getListado() {
        return listado;
    }

    public void setListado(List<Usuario> listado) {
        this.listado = listado;
    }
}
