package com.jwtauth.JwtAuth.service;

import com.jwtauth.JwtAuth.models.User;

import java.util.List;

public interface IUserService {
    void addUser(User request);
    List<User> getAllUsers();
}
