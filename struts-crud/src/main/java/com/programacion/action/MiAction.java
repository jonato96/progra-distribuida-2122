package com.programacion.action;

import com.programacion.servicios.Operaciones;
import com.programacion.servicios.ServicioUsuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import javax.inject.Inject;

@Action(value="helloAction",results={@Result(name="success",location="/result.jsp")})
public class MiAction {
    @Inject
    private Operaciones servicio;

    @Inject
    private ServicioUsuario misUsuarios;

    private String name;
    private String resultado;

    public String execute(){
        resultado = "El resultado de la suma es "+ servicio.suma(2,2);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String name) {
        this.resultado = resultado;
    }
}
