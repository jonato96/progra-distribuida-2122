package com.programacion.service.interfaces;

import com.programacion.dto.Type;

import java.util.List;

public interface ServiceType {

    List<Type> listar();
    Type listarPorId(Integer id);

}
