package com.example.jpa2_app.web;

import com.example.jpa2_app.entities.User;
import com.example.jpa2_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{userName}")
    public User user(@PathVariable String userName) //sa veut dire que ce parametre cest le param qui vient dans le path
    {
        User user=userService.findUserByUserName(userName);
        return user;
    }

}
