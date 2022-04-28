package com.programacion.services;

import com.programacion.entiites.Vet;

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
public class VetServiceImpl implements VetService{

    @Inject
    @Named("test")
    private DataSource ds;

    @Override
    public List<Vet> findAll() {
        List<Vet> listado = new ArrayList<>();
        Connection con = null;
        try {
            con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from vets");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vet obj = new Vet();
                obj.setId(rs.getInt(1));
                obj.setFirtName(rs.getString(2));
                obj.setLastName(rs.getString(3));
                listado.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listado;
    }

    @Override
    public Vet findById(Integer id) {
        Connection con = null;
        Vet obj = new Vet();
        try {
            con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from vets where id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                obj.setId(rs.getInt(1));
                obj.setFirtName(rs.getString(2));
                obj.setLastName(rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return obj;
    }
}
