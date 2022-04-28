package com.programacion.servicio;

import com.programacion.entidad.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioUsuarioImpl implements ServicioUsuario{

    private Map<Integer, Usuario> usuarios = new HashMap<>();

    {

        Usuario miUser = new Usuario(1, "Jonathan", "jjsanchezl1");
        usuarios.put(miUser.getId(), miUser);

    }

    @Override
    public void create(Usuario obj) {
        usuarios.put(obj.getId(), obj);
    }

    @Override
    public List<Usuario> findAll() {
//        List<Usuario> miLista = new ArrayList<>();
//        miLista.addAll(usuarios.values());
//        return miLista;
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public Usuario find(Integer id) {
        return usuarios.get(id);
    }

    @Override
    public void update(Usuario obj) {
        usuarios.put(obj.getId(), obj);
    }

    @Override
    public void delete(Integer id) {
        usuarios.remove(id);
    }
}
