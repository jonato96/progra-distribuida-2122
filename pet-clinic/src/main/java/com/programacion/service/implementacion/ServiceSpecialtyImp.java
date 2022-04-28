package com.programacion.service.implementacion;

import com.programacion.dto.Specialty;
import com.programacion.service.interfaces.ServiceSpecialty;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceSpecialtyImp implements ServiceSpecialty {

    @Inject
    @Named("supleDataSource")
    private DataSource dataSource;

    @Override
    public List<Specialty> listar(){
        List<Specialty> todos = new ArrayList<>();
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM specialties");
             ResultSet rs = ps.executeQuery()) {
            while( rs.next() ) {
                Specialty p = new Specialty();
                p.setId( rs.getInt(1) );
                p.setNombre( rs.getString(2));
                todos.add(p);
            }
        }
        catch( SQLException ex )
        {
            ex.printStackTrace();
        }
        return todos;
    }

    @Override
    public Specialty listarPorId(Integer id) {
        Specialty s = new Specialty();
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from specialties where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)) {
                s.setId(rs.getInt(1));
                s.setNombre(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }

}
