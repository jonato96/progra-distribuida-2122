package com.programacion.interfaces;

import com.programacion.entities.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> findAll();
    Visit findById(Integer id);
}
