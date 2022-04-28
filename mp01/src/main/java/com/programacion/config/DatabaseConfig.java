package com.programacion.config;

import com.zaxxer.hikari.HikariDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import javax.ws.rs.Produces;

@ApplicationScoped
public class DatabaseConfig {

    @ConfigProperty(name = "driver")
    private String driver;
    @ConfigProperty(name = "url")
    private String url;
    @ConfigProperty(name = "user")
    private String user;
    @ConfigProperty(name = "pass")
    private String pass;

    @ApplicationScoped
    @Produces
    public DataSource dataSource(){
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(driver);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
//        ds.setDriverClassName("org.postgresql.Driver");
//        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/distribuida22");
//        ds.setUsername("postgres");
//        ds.setPassword("adminPRO96");
        return ds;
    }
}
