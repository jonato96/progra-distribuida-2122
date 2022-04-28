package com.programacion.rest;

import com.programacion.model.Review;
import com.programacion.service.ReviewService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/reviews")
public class ReviewRest {
    @Inject
    ReviewService service;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAll(){
        service.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review findById(@PathParam("id") Integer id){
        return service.findById(id);
    }
}
