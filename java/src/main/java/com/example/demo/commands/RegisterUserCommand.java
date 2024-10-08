package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

public class RegisterUserCommand implements ICommand 
{
    private final UserService userService;
    public RegisterUserCommand(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens) 
    {
        User user = userService.registerUser(tokens.get(1));
        System.out.println(user);
    }
    
}
