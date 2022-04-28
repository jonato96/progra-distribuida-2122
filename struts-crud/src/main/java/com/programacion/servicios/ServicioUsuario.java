package com.programacion.servicios;

import com.programacion.db.Usuario;

import java.util.List;

public interface ServicioUsuario {

    List<Usuario> usuarios();

    void delete(String nombre);

}
