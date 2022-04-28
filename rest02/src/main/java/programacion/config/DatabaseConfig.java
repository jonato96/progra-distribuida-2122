package programacion.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class DatabaseConfig {
    @Produces
    @ApplicationScoped
    public DataSource dataSource(){
        //DriverManager.getConnection(url, use, pass); <---NO
        //DataSource
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/distribuida22");
        ds.setUsername("postgres");
        ds.setPassword("adminPRO96");
        //ds.setMinimumIdle(1);
        //ds.setMaximumPoolSize(10);
        return ds;
    }
}
