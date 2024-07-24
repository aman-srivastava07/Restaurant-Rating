package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant
{
    private final String id;
    private final String restaurantName;
    //To calculate  average rating, we declare attributes totalRating and totalReviewsCount
    // private Double totalRating;
    // private Integer totalReviewsCount;
    private List<Review> listOfReviews;

    //constructors(iinitialization, valiaation, default values)
    public Restaurant(String id, String restaurantName)
    {
        this.id = id;
        this.restaurantName = restaurantName;
        // totalRating = 0.0;
        // totalReviewsCount = 0;
        listOfReviews = new ArrayList<>();
    }

    public Restaurant(String restaurantName)
    {
        this(null, restaurantName);
    }

    public Restaurant(String id, String restaurantName, List<Review> listOfReviews)
    {
        this.id = id;
        this.restaurantName = restaurantName;
        // totalRating = 0.0;
        // totalReviewsCount = 0;
        this.listOfReviews =listOfReviews;
    }

    public Restaurant(String restaurantName, List<Review> listOfReviews)
    {
        this(null, restaurantName, listOfReviews);
    }

    //public getter
    public String getId()
    {
        return id;
    }

    // public Double getTotalRating()
    // {
    //     return totalRating;
    // }

    // public Integer getTotalReviewsCount()
    // {
    //     return totalReviewsCount;
    // }
    
    public String getRestaurantName()
    {
        return restaurantName;
    }

    public List<Review> getAllReviews()
    {
        return listOfReviews;
    }

    //setter(if required)
    // public void setTotalRating(Double rating)   //update or set
    // {
    //     this.totalRating = rating;
    // }
    
    //Behaviours
    public Double getAverageRating()
    {
        //return this.totalRating/this.totalReviewsCount;

        //we want to fetch only ratings from review class attributes and put them in a list.
        List<Integer> rating = listOfReviews.stream().map(u->u.getRating()).collect(Collectors.toList());
        
        //we want to calculate sum of all rating present in list
        Integer sumOfRatings = rating.stream().mapToInt(Integer::intValue).sum();

        Double average = ((double)sumOfRatings/(double)rating.size());

        return average;
    }

    //a r d c (if required)
    
    // public void addReview(Review review)
    // {
    //     listOfReviews.add(review);
    //     ++totalReviewsCount;
    //     totalRating = totalRating + review.getRating();
    //     setTotalRating(totalRating);
    //     //Long updatedAvgRating = calculateAvgRating();
    // }

    
    //toString()
    @Override
    public String toString()
    {
        return "Restaurant [id=" + getId() + "]";
    }

    
}
