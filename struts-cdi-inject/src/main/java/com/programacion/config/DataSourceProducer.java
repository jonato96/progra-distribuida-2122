package com.programacion.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class DataSourceProducer {

    @ApplicationScoped
    @Produces
    public DataSource miData() {
        HikariDataSource dataSource = new HikariDataSource();
        String url = "jdbc:postgresql://localhost:5432/usuario";
        String user = "postgres";
        String pass = "adminPRO96";
        String driver = "org.postgresql.Driver";
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
        dataSource.setDriverClassName(driver);
        dataSource.setMinimumIdle(1);
        dataSource.setMaximumPoolSize(2);
        return dataSource;
    }

}
