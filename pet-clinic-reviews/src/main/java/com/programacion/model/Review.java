package com.programacion.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Review {
    private String id;
    private String reviewId;
    private String rating;
    private String comment;
    private Integer vetId;
    private String dateAdded;
}
