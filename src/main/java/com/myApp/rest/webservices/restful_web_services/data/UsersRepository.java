package com.myApp.rest.webservices.restful_web_services.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}
