package com.programacion.services;

import com.programacion.entiites.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> findAll();
    Specialty findById(Integer id);
}
