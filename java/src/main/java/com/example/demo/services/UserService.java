package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService 
{
    private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //Register User
    public User registerUser(String name)
    {
        //2 Steps
        //without id
        User user = new User(name);
        return userRepository.save(user);
    }
    
}
