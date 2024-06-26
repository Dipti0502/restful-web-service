package com.myApp.rest.webservices.restful_web_services.service;

import com.myApp.rest.webservices.restful_web_services.data.UserEntity;
import com.myApp.rest.webservices.restful_web_services.data.UsersRepository;
import com.myApp.rest.webservices.restful_web_services.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
	
	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository, 
			BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
 
	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub

		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper mapper = new ModelMapper();
		UserEntity user = mapper.map(userDetails,UserEntity.class);
		usersRepository.save(user);
		UserDto dto = mapper.map(user,UserDto.class);
		return dto;
	}

}
