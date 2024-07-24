package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrder implements ICommand 
{
    private final ReviewService reviewService;
    public GetReviewsFilterOrder(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }
    @Override
    public void invoke(List<String> tokens) 
    {
       System.out.println(reviewService.getReviewsFilterOrder(tokens.get(1), Integer.valueOf(tokens.get(2)), Integer.valueOf(tokens.get(3)), tokens.get(4)));
    }
}
