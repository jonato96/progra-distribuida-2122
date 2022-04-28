package com.programacion;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

//@Action("helloAction")
//@Result(name = "success", location = "/paginas/results.jsp")
@Action(value="holaMundo",results={@Result(name="success",location="/paginas/results.jsp")})
public class HelloAction {

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
