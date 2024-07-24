package com.example.demo.entities;

import java.util.LinkedList;
import java.util.List;

public class User 
{
    private final String id;
	private final String userName;
    private List<Review> listOfReviews;

    //constructor
    public User(String id, String userName)
    {
        this.id = id;
        this.userName = userName;
        this.listOfReviews = new LinkedList<>();
    }

    public User(String userName)
    {
        this(null, userName);
    }

    public User(String id, String userName, List<Review> listOfReviewseviews)
    {
        this(id, userName);
        this.listOfReviews = listOfReviewseviews;
    }

    public User(String userName, List<Review> listOfReviews)
    {
        this(null, userName, listOfReviews);
    }

    //public getter
    public String getId()
    {
        return id;
    }

    public String getUserName()
    {
        return userName;
    }

    public List<Review> getReviews()
    {
        return listOfReviews;
    }

    //setter if required

    //ardc

    //toString()
    @Override
    public String toString()
    {
        return "User [id=" + getId() + "]";
    }
    
}
