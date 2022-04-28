package com.programacion.action;

import com.programacion.db.Usuario;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

@Action(value="readAction",results={@Result(name="success",location="/index.jsp")})
public class ReadAction {

    @Inject
    private ServicioUsuario servicio;

    public String execute(){
        List<Usuario> listado = servicio.usuarios();
        return "success";
    }

}
