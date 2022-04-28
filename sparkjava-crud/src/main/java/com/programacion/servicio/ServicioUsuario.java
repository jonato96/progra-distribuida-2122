package com.programacion.servicio;

import com.programacion.entidad.Usuario;

import java.util.List;

public interface ServicioUsuario {

    void create(Usuario obj);
    List<Usuario> findAll();
    Usuario find(Integer id);
    void update(Usuario obj);
    void delete(Integer id);

}
