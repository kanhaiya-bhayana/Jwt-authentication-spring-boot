package com.jwtauth.JwtAuth.service;

import com.jwtauth.JwtAuth.models.User;

import java.util.List;

public interface IUserService {
    public void addUser(User request);
    public List<User> getAllUsers();
}
