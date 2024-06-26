package com.myApp.rest.webservices.restful_web_services.ui.controllers;

import com.myApp.rest.webservices.restful_web_services.service.UserService;
import com.myApp.rest.webservices.restful_web_services.ui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUser(){

        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){

        return principal.getName();
    }
}
