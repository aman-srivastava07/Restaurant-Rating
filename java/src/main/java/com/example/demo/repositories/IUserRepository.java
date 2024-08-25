package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;

public interface IUserRepository 
{
    public User save(User user);

    public Optional<User> findById(String id);
    public List<User> findAll();

    public Integer count();

    public void delete(String id);

    public Optional<User> findByName(String userName);
    
}
