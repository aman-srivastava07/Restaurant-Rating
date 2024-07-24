package com.example.demo.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IReviewRepository;

public class ReviewService 
{
    private final IReviewRepository reviewRepository;
    public ReviewService(IReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    //Add Review
    public Review addReview(Integer rating, String userId, String restaurantId, List<String> dishNames, String description)
    {
        // Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Invalid restaurant id " + restaurantId));
        // List<Review> allExistReviews = restaurant.getAllReviews();
        // Double totalRating = restaurant.getTotalRating();
        // Integer totalReviewsCount = restaurant.getTotalReviewsCount();
        // Double currentRating = restaurant.calculateAvgRating();
        //restaurant.setTotalRating(updatedRating);

        //2 steps
        //without id
        Review review = new Review(rating, userId, restaurantId ,dishNames, description);
        return reviewRepository.save(review);

        //added
        // allExistReviews.add(review);
        // ++totalReviewsCount;
        // totalRating = totalRating + review.getRating();
        // Double updatedRating = restaurant.calculateAvgRating();
        // restaurant.setTotalRating(updatedRating);
        
        

        // Review reviewObj  = reviewRepository.save(review);
        // return reviewObj.toString() + "added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
    }

    //Add Rating
    public Review addRating(Integer rating, String userId, String restaurantId)
    {
        //return  addReview(rating,userId, restaurantId, null, null);
        // Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Invalid restaurant id " + restaurantId));

        // List<Review> allExistReviews = restaurant.getAllReviews();
        // Double totalRating = restaurant.getTotalRating();
        // Integer totalReviewsCount = restaurant.getTotalReviewsCount();

        Review userReview = new Review(rating, userId, restaurantId);
        return reviewRepository.save(userReview);
        // allExistReviews.add(review);
        // ++totalReviewsCount;
        // totalRating = totalRating + review.getRating();
        // Double updatedRating = restaurant.calculateAvgRating();
        // restaurant.setTotalRating(updatedRating);

        
        
        // Review reviewObj  = reviewRepository.save(review);
        // return reviewObj.toString() + " added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
    }

    //Get Reviews
    public List<Review> getReviews(String restaurantId, String Order)
    {
        //Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        //Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Invalid restaurant id " + restaurantId));
       List<Review> reviewsList = reviewRepository.findAll();

        // if(restaurant == null)
        // {
        //     throw new RuntimeException("Invalid restaurant id " + restaurantId);
        // }

        //List<Review> reviewsList = restaurant.getAllReviews();

        //if(Order.equals(String.valueOf(RatingOrder.RATING_ASC)))
        //if(Order.equals(RatingOrder.RATING_ASC))
        if(Order.equals("RATING_ASC"))
        {
            //restaurantsList.sort(Comparator.comparing(Restaurant::getAvgRating).reversed());
            //error reason
            //The error message indicates that the sort method is not applicable because the types of the 
            //List and the Comparator do not match. 
            //Specifically, it seems you are trying to sort a list of Review objects using a 
            // Comparator for Restaurant objects.
            
            //reviewsList.sort(Comparator.comparing(Restaurant::getAvgRating));
            return reviewsList.stream().filter(u->u.getRestaurantId().equals(restaurantId)).sorted(Comparator.comparing(Review::getRating)).collect(Collectors.toList());
        }
        else
        {
            //reviewsList.sort(Comparator.comparing(Restaurant::getAvgRating).reversed());   not working
            //eror reason: The error message indicates that the sort method is not applicable because the types of the List and the Comparator do not match. Specifically, it seems you are trying to sort a list of Review objects using a Comparator for Restaurant objects.
            // Collections.sort(reviewsList, new Comparator<Restaurant>() {
            //     @Override
            //     public int compare(Restaurant p1, Restaurant p2) {
            //         return p2.getAvgRating().compareTo(p1.getAvgRating());
            //     }
            // });
            return reviewsList.stream().filter(u->u.getRestaurantId().equals(restaurantId)).sorted(Comparator.comparing(Review::getRating).reversed()).collect(Collectors.toList());
        }
        
        // String result = "[";
        // for(int i=0; i<reviewsList.size(); i++)
        // {
        //     if(i == reviewsList.size()-1)
        //     {
        //         result += reviewsList.get(i).toString();
        //     }
        //     else
        //     {
        //         result += reviewsList.get(i).toString() + ", ";
        //     }
        // }
        // result += "]";

        // return result;
    }

    //Get Reviews Filter Order
    public List<Review> getReviewsFilterOrder(String restaurantId, Integer low, Integer high, String Order)
    {
        //Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        List<Review> reviewsList =  reviewRepository.findAll().stream().filter(u->u.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());


        // if(restaurant == null)
        // {
        //     throw new RuntimeException("Invalid restaurant id " + restaurantId);
        // }

        // List<Review> reviewsList = restaurant.getAllReviews();

        // if(Order.equals(RatingOrder.RATING_ASC))
        if(Order.equals("RATING_ASC"))
        {
            //reviewsList.sort(Comparator.comparing(Review::getRating));
            return reviewsList.stream().filter(u->(u.getRating()>=low && u.getRating()<=high)).sorted(Comparator.comparing(Review:: getRating)).collect(Collectors.toList());
        }
        else
        {
            return reviewsList.stream().filter(u->(u.getRating()>=low && u.getRating()<=high)).sorted(Comparator.comparing(Review:: getRating).reversed()).collect(Collectors.toList());
        }

        // List<Review> filteredList = reviewsList.stream().filter(u-> u.getRating() > Double.parseDouble(low) && u.getRating() < Double.parseDouble(high)).collect(Collectors.toList());


        // String result = "[";
        // for(int i=0; i<filteredList.size(); i++)
        // {
        //     if(i == filteredList.size()-1)
        //     {
        //         result += filteredList.get(i).toString();
        //     }
        //     else
        //     {
        //         result += filteredList.get(i).toString() + ", ";
        //     }
        // }
        // result += "]";

        // return result;
    }
    
}
