package com.programacion.service.interfaces;

import com.programacion.dto.Visit;

import java.util.List;

public interface ServiceVisit {

    List<Visit> listar();
    Visit listarPorId(Integer id);

}
