package com.example.demo.entities;

import java.util.LinkedList;
import java.util.List;

public class Review
{
    private final String id;
    private final String userId;
	private final String restaurantId;
    //private Double rating;
    private Integer rating;
	private List<String> dishNames;       
	private String description;

    //constructor
    public Review(String id, Integer rating, String userId, String restaurantId)
    {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        dishNames =  new LinkedList<>();
        description = null;
    }

    public Review(Integer rating, String userId, String restaurantId)
    {
        this(null, rating, userId,restaurantId);
    }

    public Review(String id,  Integer rating, String userId, String restaurantId, List<String> dishNames, String description)
    {
        // this.id = id;
        // this.userId = userId;
        // this.restaurantId = restaurantId;
        //this.rating = rating;
        this(id, rating, userId, restaurantId);
        this.dishNames =  dishNames;
        this.description = description;
    }

    public Review(Integer rating, String userId, String restaurantId, List<String> dishNames, String description)
    {
        this(null, rating, userId, restaurantId, dishNames, description);
    }

    //public getter
    public String getId()
    {
        return id;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getRestaurantId()
    {
        return restaurantId;
    }

    public Integer getRating()
    {
        return rating;
    }

    public List<String> getDishNames()
    {
        return dishNames;
    }

    public String getDescription()
    {
        return description;
    }

    //setter (if required)
    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public void setDishNames(List<String> dishNames)
    {
        this.dishNames = dishNames;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    //a r d c (but we don't need it here)

    @Override
    public String toString()
    {
        return "Review [id=" + getId() + "]";
    }
    
}