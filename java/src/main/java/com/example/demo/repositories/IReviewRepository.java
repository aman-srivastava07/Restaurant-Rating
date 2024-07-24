package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Review;

public interface IReviewRepository 
{
    public Review save(Review review);

    public Optional<Review> findById(String id);
    public List<Review> findAll();

    public Integer count();

    public void delete(String id);

    //public List<Review> reviewByRating(Double rating);


    
}
