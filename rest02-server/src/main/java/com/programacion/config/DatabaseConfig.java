package com.programacion.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class DatabaseConfig {
    @Produces
    @ApplicationScoped
    public DataSource dataSource(){
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/distribuida22");
        ds.setUsername("postgres");
        ds.setPassword("adminPRO96");
        return ds;
    }
}
