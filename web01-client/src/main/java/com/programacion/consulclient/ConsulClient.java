package com.programacion.consulclient;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.health.Service;
import com.orbitz.consul.model.health.ServiceHealth;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import java.net.URI;
import java.util.List;

@RequestScoped
public class ConsulClient {
    @Produces
    public String getUrl(){
        Consul consul = Consul.builder().build();
        HealthClient healthClient = consul.healthClient();
        List<ServiceHealth> instancias = healthClient.getHealthyServiceInstances("mp01")
                .getResponse();
        instancias.forEach(s ->{
            Service srv = s.getService();
            System.out.printf("http://%s:%d\n", srv.getAddress(), srv.getPort());
        });
        String url = "";
        for (ServiceHealth s: instancias){
            Service srv = s.getService();
            url = String.format("http://%s:%d", srv.getAddress(), srv.getPort());
        }
        //en caso de usar jaxrs client
        //return url + "/personas";

        //en caso de usar proxy client
        return url;
    }
}
