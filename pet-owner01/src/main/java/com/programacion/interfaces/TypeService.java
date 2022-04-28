package com.programacion.interfaces;

import com.programacion.entities.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAll();
    Type findById(Integer id);
}
