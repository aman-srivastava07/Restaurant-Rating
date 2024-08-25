package com.example.demo.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.services.ReviewService;

public class AddReviewCommand implements ICommand 
{
    private final ReviewService reviewService;
    public AddReviewCommand(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) 
    {
        // List<String> dishNames = new ArrayList<>();
        // dishNames.add(tokens.get(4));

        List<String> dishNames = Arrays.asList(tokens.get(4).split(" "));

       reviewService.addReview(Integer.valueOf(tokens.get(1)), tokens.get(2), tokens.get(3), dishNames, tokens.get(tokens.size()-1));
    }
    
}
