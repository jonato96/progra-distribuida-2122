package com.programacion.service.interfaces;

import com.programacion.dto.Owner;

import java.util.List;

public interface ServiceOwner {

    List<Owner> listar();
    Owner listarPorId(Integer id);

}
