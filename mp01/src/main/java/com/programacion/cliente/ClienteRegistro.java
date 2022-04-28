package com.programacion.cliente;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.health.Service;
import com.orbitz.consul.model.health.ServiceHealth;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ClienteRegistro {
    public static void main(String[] args) throws IOException {
        Consul consul = Consul.builder()
                                .build();
        HealthClient healthClient = consul.healthClient();
        List<ServiceHealth> instancias = healthClient.getHealthyServiceInstances("mp01")
                .getResponse();
        //Imprimimos las instancias saludables
        instancias.forEach(s->{
            Service srv = s.getService();
            System.out.printf("http://%s:%d\n", srv.getAddress(), srv.getPort());
        });

        String url = "";
        //De la lista de servicios saludables obtenemos alguno, en este caso el ultimo de la lista
        for(ServiceHealth s:instancias){
            Service srv = s.getService();
            url = String.format("http://%s:%d", srv.getAddress(), srv.getPort());
        }
        //Http client para testear
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet req = new HttpGet(url+"/hola");
        var response = client.execute(req);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
    }
}
