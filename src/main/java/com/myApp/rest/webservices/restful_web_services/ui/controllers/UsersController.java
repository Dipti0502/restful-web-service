package com.myApp.rest.webservices.restful_web_services.ui.controllers;

import com.myApp.rest.webservices.restful_web_services.service.UsersService;
import com.myApp.rest.webservices.restful_web_services.shared.UserDto;
import com.myApp.rest.webservices.restful_web_services.shared.WelcomeMessageDto;
import com.myApp.rest.webservices.restful_web_services.ui.model.CreateUserRequestModel;
import com.myApp.rest.webservices.restful_web_services.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	UsersService usersService;

	@GetMapping("/status/check")
	public String status()
	{
		return "Working on port " + env.getProperty("local.server.port");
	}

	@GetMapping("/getWelcomeMessage")
	public WelcomeMessageDto getWelcomeMessage()
	{
         WelcomeMessageDto dto = new WelcomeMessageDto();
		 dto.setMessage("Welcome! Love getting more leads");
		// throw new RuntimeException("Some error has occurred! contact at support ***-***") ;
		return dto;
	}
 
	
	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser( @RequestBody CreateUserRequestModel userDetails)
	{
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetails,UserDto.class);
		UserDto createdUSer = usersService.createUser(userDto);
		CreateUserResponseModel userResponseModel = modelMapper.map(createdUSer, CreateUserResponseModel.class);
		return new ResponseEntity<>(userResponseModel,HttpStatus.CREATED);
	}
}
