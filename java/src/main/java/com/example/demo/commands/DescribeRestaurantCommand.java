package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class DescribeRestaurantCommand implements ICommand
{
    private final RestaurantService restaurantService;
    public DescribeRestaurantCommand(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }
    @Override
    public void invoke(List<String> tokens) 
    {
        System.out.println(restaurantService.describeRestaurant(tokens.get(1)));
        
    }
    
}
