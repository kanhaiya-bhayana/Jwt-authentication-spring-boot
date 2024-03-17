package com.jwtauth.JwtAuth.controllers;

import com.jwtauth.JwtAuth.models.User;
import com.jwtauth.JwtAuth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private IUserService userService;

    @Autowired
    public HomeController(IUserService service){
        userService = service;
    }

    @PostMapping("/adduser")
    private String addUser(@RequestBody User request){
        userService.addUser(request);
        return "User added successfully";
    }

    @GetMapping("/users")
    private List<User> getUsers(){
        return userService.getAllUsers();
    }
}
