package com.programacion.servicios;

import com.programacion.entidades.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ServicioUsuarioImpl implements ServicioUsuario {

    @Inject
    private DataSource dataSource;

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void crear(Usuario p) {
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement("INSERT INTO clientes(nombre, apellido, direccion) VALUES (?, ?, ?);");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDireccion());
            ps.executeUpdate(); // Ejecuto la sentencia
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: prepareStatement y la conexión
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement("SELECT * FROM clientes ORDER BY id");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Usuario buscar(int id) {
        Usuario p = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement("SELECT * FROM clientes WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new Usuario(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return p;
    }

    @Override
    public void editar(Usuario p) {
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement("UPDATE clientes SET nombre=?, apellido=?, direccion=? WHERE id=?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDireccion());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void eliminar(int p) {
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement("DELETE FROM clientes WHERE id=?");
            ps.setInt(1, p);
            ps.executeUpdate(); // Ejecuto la sentencia
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: prepareStatement y la conexión
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

}
