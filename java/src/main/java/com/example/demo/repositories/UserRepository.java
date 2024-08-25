package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository 
{
    private final Map<String,User> userMap;
    private Long autoincrement = 1L;

    public UserRepository()
    {
        userMap = new HashMap<>();
    }

    @Override
    public User save(User user) 
    {
        User userObj = new User(String.valueOf(autoincrement), user.getUserName());
        userMap.put(userObj.getId(), userObj);

        ++autoincrement;
        return userObj;
    }

    @Override
    public Optional<User> findById(String id) 
    {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> findAll() 
    {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Integer count() 
    {
        return userMap.size();
    }

    @Override
    public void delete(String id) 
    {
        userMap.remove(id);
    }

    @Override
    public Optional<User> findByName(String userName) 
    {
        return userMap.values().stream().filter(u->u.getUserName().equals(userName)).findFirst();
    }
    
}
