package com.programacion.config;

import com.programacion.servicios.ServicioLog;
import com.programacion.servicios.ServicioLogImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.programacion")
public class Config {

    @Bean
    public ServicioLog createLog(){
        System.out.println("PRODUCTOR ServicioLogProducer");
        return new ServicioLogImpl();
    }

}
