package com.programacion.service;

import com.programacion.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findById(Integer id);
}
