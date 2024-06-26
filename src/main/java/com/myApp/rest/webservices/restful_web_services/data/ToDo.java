package com.myApp.rest.webservices.restful_web_services.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ToDo {

    private long id;
    private String userName;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
