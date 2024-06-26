package com.myApp.rest.webservices.restful_web_services.shared;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.io.Serializable;


public class WelcomeMessageDto implements Serializable {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
