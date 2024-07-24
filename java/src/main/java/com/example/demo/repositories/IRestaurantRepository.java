package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository 
{
    public Restaurant save(Restaurant restaurant);

    public Optional<Restaurant> findById(String id);
    public List<Restaurant> findAll();

    public Integer count();

    public void delete(String id);

    public Optional<Restaurant> getByName(String restaurantName);


    
}
