package com.programacion.services;

import com.programacion.entiites.Vet;

import java.util.List;

public interface VetService {
    List<Vet> findAll();
    Vet findById(Integer id);
}
