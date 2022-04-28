package com.programacion.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.programacion.model.Review;
import org.bson.Document;
import static com.mongodb.client.model.Filters.gte;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReviewServiceImpl implements ReviewService{

    @Inject
    MongoDatabase db;

    @Override
    public List<Review> findAll() {
        Document mydoc = db.getCollection("reviews").find().first();
        System.out.println(mydoc.toJson());
        System.out.println("Conectado");
        return null;
    }

    @Override
    public Review findById(Integer id) {
        MongoCollection<Document> collection = db.getCollection("reviews");
        Document document = collection.find(gte("vetId", id)).first();
        Review review = new Review();
        review.setId(document.getString("_id"));
        review.setReviewId(document.getString("reviewId"));
        review.setComment(document.getString("comment"));
        review.setRating(document.getString("rating"));
        review.setVetId(document.getInteger("vetId"));
        review.setDateAdded(document.getString("dateAdded"));
        return review;

    }
}
