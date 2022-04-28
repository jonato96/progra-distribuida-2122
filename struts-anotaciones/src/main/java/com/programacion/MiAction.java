package com.programacion;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value="miAction",results={@Result(name="success",location="/paginas/results.jsp")})
public class MiAction {

    private String firstName;

    public String execute(){
        System.out.println("El nombre es "+firstName);
        return "success";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
