package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository 
{
    private final Map<String, Review> reviewMap;
    private Long autoincrement = 1L;

    public ReviewRepository()
    {
        reviewMap = new HashMap<>();
    }

    @Override
    public Review save(Review review) 
    {
        //4 steps
        Review reviewObj = new Review(String.valueOf(autoincrement), review.getRating(),review.getUserId() , review.getRestaurantId(), review.getDishNames(), review.getDescription());
        reviewMap.put(reviewObj.getId(), reviewObj);

        ++autoincrement;
        return reviewObj;

    }

    @Override
    public Optional<Review> findById(String id) 
    {
        return Optional.ofNullable(reviewMap.get(id));
    }

    @Override
    public List<Review> findAll() 
    {
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Integer count() 
    {
        return reviewMap.size();
    }

    @Override
    public void delete(String id) 
    {
        reviewMap.remove(id);
    }

    // @Override
    // public List<Review> reviewByRating(Double rating) 
    // {
    //     return reviewMap.values().stream().filter(u->u.getRating() == rating).collect(Collectors.toList());
    // }
    
}
