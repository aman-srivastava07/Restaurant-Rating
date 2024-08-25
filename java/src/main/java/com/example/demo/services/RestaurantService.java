package com.example.demo.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;

public class RestaurantService 
{
    private final IRestaurantRepository restaurantRepository;
    private final IReviewRepository reviewRepository;
    public RestaurantService(IRestaurantRepository restaurantRepository, IReviewRepository reviewRepository)
    {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }
    
    //Register Restaurant
    public Restaurant registerRestaurant(String name)
    {
        //2 steps
        //without id
        Restaurant restaurant = new Restaurant(name);
        return restaurantRepository.save(restaurant);
    }
    
    //Describe Restaurant
    public String describeRestaurant(String restaurantId)
    {
        //Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        // if(restaurant == null)
        // {
        //     throw new RuntimeException("Invalid restaurant id " + restaurantId);
        // }
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Invalid restaurant id " + restaurantId));

        //find all reviews for above restaurant that we find using given restaurant id
        List<Review> reviewForFetchedRestaurant = reviewRepository.findAll().stream().filter(u->u.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());


        Restaurant restaurantObject = new Restaurant(restaurantId, restaurant.getRestaurantName(), reviewForFetchedRestaurant);

       
        //return "Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getRestaurantName() + ", rating=" + restaurant.getAverageRating() + "]";
        return "Restaurant [id=" + restaurantId + ", name=" + restaurantObject.getRestaurantName() + ", rating=" + restaurantObject.getAverageRating() + "]";
        
    }

    //List Restaurant  (in decreasing order of rating)
    //public String listRestaurant()       //v1
    public List<Restaurant> listRestaurant()
    {
        List<Restaurant> restaurantsList = restaurantRepository.findAll();

        //List<Restaurant> restaurantsSortedList = restaurantsList.stream().sorted((c1,c2)-> (c1.getAvgRating() - c2.getAvgRating())).collect(Collectors.toList());
        
        //products.sort(Comparator.comparing(Product::getPrice).reversed());
        // restaurantsList.sort(Comparator.comparing(Restaurant::getAverageRating).reversed());
        restaurantsList.sort(Comparator.comparing(Restaurant::getAverageRating).reversed());
        return restaurantsList;
         
        //v1
        // String result = "[";
        // for(int i=0; i<restaurantsList.size(); i++)
        // {
        //     if(i == restaurantsList.size()-1)
        //     {
        //         result += restaurantsList.get(i).toString();
        //     }
        //     else
        //     {
        //         result += restaurantsList.get(i).toString() + ", ";
        //     }
        // }

        // result += "]";

        // return result;
    }
    
}
