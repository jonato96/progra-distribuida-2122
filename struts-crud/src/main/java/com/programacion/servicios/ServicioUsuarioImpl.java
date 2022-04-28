package com.programacion.servicios;

import com.programacion.db.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ServicioUsuarioImpl implements ServicioUsuario{

    private final Usuario u1 = new Usuario("Jonathan", "Sanchez", "Quininde");
    private final Usuario u2 = new Usuario("Jesus", "Sanchez", "Quito");
    private final Usuario u3 = new Usuario("Nato", "Sanchez", "Riobamba");

    private final List<Usuario> usuarios  = new ArrayList<Usuario>();


    @Override
    public void delete(String nombre) {



    }

    @Override
    public List<Usuario> usuarios() {
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        for (Usuario u:usuarios) {
            System.out.println("nombre:"+u.getNombre());
        }
        return usuarios;
    }
}
