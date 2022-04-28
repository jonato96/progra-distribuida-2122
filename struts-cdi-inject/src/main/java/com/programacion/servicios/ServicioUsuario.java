package com.programacion.servicios;

import com.programacion.entidades.Usuario;

import java.util.List;

public interface ServicioUsuario {

    void crear(Usuario p);

    List<Usuario> buscarTodos();

    Usuario buscar(int id);

    void editar(Usuario p);

    void eliminar(int p);

}
