package com.programacion.services;

import com.programacion.entiites.Specialty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SpecialtyServiceImpl implements SpecialtyService{

    @Inject
    @Named("test")
    private DataSource ds;

    @Override
    public List<Specialty> findAll() {
        List<Specialty> listado = new ArrayList<>();
        Specialty obj = null;
        try (Connection connection = this.ds.getConnection();
             PreparedStatement ps =
                     connection.prepareStatement(" select * from specialities order by id");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                obj = new Specialty();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                listado.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listado;
    }

    @Override
    public Specialty findById(Integer id) {
        Specialty obj = null;
        try (Connection connection = this.ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(" select * from specialities where id = ?")){
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)) {
                obj = new Specialty();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
}
