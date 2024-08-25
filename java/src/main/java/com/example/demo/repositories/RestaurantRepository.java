package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository 
{
    private final Map<String, Restaurant> restaurantMap;
    private Long autoIncrement = 1L; //only  Long present is here

    public RestaurantRepository()
    {
        this.restaurantMap = new HashMap<>();
    }

    @Override
    public Restaurant save(Restaurant restaurant) 
    {
        //4 steps
        //with id
        Restaurant restaurantObj = new Restaurant(String.valueOf(autoIncrement), restaurant.getRestaurantName());
        //restaurantMap.put(restaurant.getId(), restaurantObj);   cause of failure: passed restaurant instead of restaurantObj
        restaurantMap.put(restaurantObj.getId(), restaurantObj);

        ++autoIncrement;
        return restaurantObj;
    }

    @Override
    public Optional<Restaurant> findById(String id) 
    {
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() 
    {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Integer count() 
    {
       return restaurantMap.size();
    }

    @Override
    public void delete(String id) 
    {
       restaurantMap.remove(id); 
    }

    @Override
    public Optional<Restaurant> getByName(String restaurantName) 
    {
        return restaurantMap.values().stream().filter(u-> u.getRestaurantName().equals(restaurantName)).findFirst();
    }
    
}
