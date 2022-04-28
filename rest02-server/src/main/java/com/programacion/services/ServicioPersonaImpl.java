package com.programacion.services;

import com.programacion.db.Persona;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersona{

    @Inject
    private DataSource dataSource;

    @Override
    public void create(Persona obj) {

        Connection con = null;
        PreparedStatement ps =  null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement("INSERT INTO PERSONA(nombre, direccion) VALUES (?, ?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public Persona findById(Integer id) {
        Persona obj = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement("SELECT * FROM PERSONA WHERE ID = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                obj = new Persona();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDireccion(rs.getString("direccion"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
                ps.close();
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return obj;
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        Persona obj = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement("SELECT * FROM PERSONA ORDER BY ID");
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Persona();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDireccion(rs.getString("direccion"));
                personas.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                ps.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return personas;
    }

    @Override
    public void update(Integer id, Persona obj) {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement("UPDATE PERSONA SET NOMBRE = ?, DIRECCION =? WHERE ID = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setInt(3, obj.getId());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement("DELETE FROM PERSONA WHERE ID = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
