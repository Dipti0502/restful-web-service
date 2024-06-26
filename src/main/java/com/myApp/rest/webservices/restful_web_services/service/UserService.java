package com.myApp.rest.webservices.restful_web_services.service;

import com.myApp.rest.webservices.restful_web_services.ui.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Dipti","ds@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Saanvi","ss@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Lileshwar","ls@gmail.com"));
    }

    public List<User> getUsers(){
        return  this.store;
    }
}
