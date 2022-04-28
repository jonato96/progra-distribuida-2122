package com.programacion.config;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.*;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AppEvents {

    private String id;

    @ConfigProperty(name = "quarkus.application.name", defaultValue = "pet-owner")
    private String name;

    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    private Integer port;

    @ConfigProperty(name = "consul.ip", defaultValue = "127.0.0.1")
    private String consulIp;

    @PostConstruct
    public void inicializar() {
        id = name + "-" + UUID.randomUUID().toString();
    }

    //public void init(@Observes @Initialized(ApplicationScoped.class) Object ev){
    public void init(@Observes StartupEvent ev) throws UnknownHostException {

        System.out.println("INICIANDO");

        //String urlChequeo = String.format("http://127.0.0.1:%d/q/health/live", port);
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("------ip "+ip);
        System.out.println("------consul "+consulIp);
        System.out.println("------puerto "+port);

        //Cuando la app inicie tenemos que registrarla
        Consul consulClient = Consul.builder()
                .withHostAndPort(HostAndPort.fromParts(consulIp, 8500))
                .build();

        String urlChequeo = String.format("http://%s:%d/q/health/live", ip, port);

        String rule = String.format("traefik.http.routers.%s.rule=PathPrefix(`/%s`)", name, name);
        String mid = String.format("traefik.http.routers.%s.middlewares=%s", name, name);
        String mid1 = String.format("traefik.http.middlewares.%s.stripprefix.prefixes=/%s", name, name);

        List<String> tags = Arrays.asList(rule, mid, mid1);

        Registration service = ImmutableRegistration.builder()
                .id(id)                 //identificador de instancia
                .name(name)             //nombre de la aplicacion
                .address(ip) //obtenemos ip de la maquina
                //.address("127.0.0.1")   //ip
                .port(port)           //puerto
                .putMeta("puerto", port.toString())
                .putMeta("ip", ip)
                .putMeta("version", "version 1.0")
                .check(
                        ImmutableRegCheck.builder()
                                .http(urlChequeo)
                                .interval(String.format("%ss", 10))
                                .deregisterCriticalServiceAfter("5s")
                                .build()
                )
                .tags(tags)
                .build();

        consulClient.agentClient().register(service);

    }

    //public void init(@Observes @Destroyed(ApplicationScoped.class) Object ev){
    public void destroy(@Observes ShutdownEvent ev) {

        System.out.println("TERMINANDO");
        //Al finalizar eliminamos el registro
        Consul consulClient = Consul.builder()
                .build();
        consulClient.agentClient().deregister(id);

    }
}
