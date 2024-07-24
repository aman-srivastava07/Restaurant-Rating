package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddRatingCommand implements ICommand 
{
    private final ReviewService reviewService;
    public AddRatingCommand(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) 
    {
       Review review = reviewService.addRating(Integer.valueOf(tokens.get(1)), tokens.get(2), tokens.get(3));
       System.out.println("Review [id=" + review.getId() +"] added successfully for Restaurant [id=" + review.getRestaurantId()+ "] by User [id=" + review.getUserId()+"]!");
    }  
}
