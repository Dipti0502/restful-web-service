package com.myApp.rest.webservices.restful_web_services.service;


import com.myApp.rest.webservices.restful_web_services.shared.UserDto;

public interface UsersService {
	UserDto createUser(UserDto userDetails);
}
