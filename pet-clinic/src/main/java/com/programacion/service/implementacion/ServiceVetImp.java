package com.programacion.service.implementacion;

import com.programacion.dto.Specialty;
import com.programacion.dto.Vet;
import com.programacion.service.interfaces.ServiceVet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceVetImp implements ServiceVet {

    @Inject
    @Named("supleDataSource")
    private DataSource dataSource;

    @Override
    public List<Vet> listar() {
        List<Vet> todos = new ArrayList<>();
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM vets");
             ResultSet rs = ps.executeQuery()) {
            while( rs.next() ) {
                Vet v = new Vet();
                v.setId( rs.getInt(1) );
                v.setNombre( rs.getString(2));
                todos.add(v);
            }
        }
        catch( SQLException ex )
        {
            ex.printStackTrace();
        }
        return todos;
    }

    @Override
    public Vet listarPorId(Integer id) {
        Vet v = new Vet();
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from vets where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)) {
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }
}
