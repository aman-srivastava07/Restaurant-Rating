package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand 
{
    private final ReviewService reviewService;
    public GetReviewsCommand(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) 
    {
        System.out.println(reviewService.getReviews(tokens.get(1), tokens.get(2)));    
    }
    
}
