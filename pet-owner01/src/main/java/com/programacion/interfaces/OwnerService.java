package com.programacion.interfaces;

import com.programacion.entities.Owner;

import java.util.List;

public interface OwnerService {
    Owner findById(Integer id);
    List<Owner> findAll();

}
