package com.jwtauth.JwtAuth.service;

import com.jwtauth.JwtAuth.models.User;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IUserService {

    private List<User> users = new ArrayList<>();

    public void addUser(User request){
        users.add(request);
    }

    public List<User> getAllUsers(){
        return users;
    }
}
