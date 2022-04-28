package com.programacion;

import com.programacion.config.Config;
import com.programacion.servicios.Operaciones;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
    public static void main(String[] args) {

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        //Buscar el componente
        Operaciones servicio = context.getBean(Operaciones.class);
        System.out.println(servicio.getClass());

        //Invocar
        int ret = servicio.sumar(5,9);
        System.out.println("La suma es: "+ret);



    }
}
