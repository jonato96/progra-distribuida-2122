package com.programacion.service;

import com.programacion.db.TipoDireccion;

import java.util.List;

public interface TipoDireccionService {

    List<TipoDireccion> findAll();
    TipoDireccion findById(Integer id);
}
