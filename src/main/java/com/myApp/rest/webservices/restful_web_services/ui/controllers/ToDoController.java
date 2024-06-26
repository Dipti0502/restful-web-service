package com.myApp.rest.webservices.restful_web_services.ui.controllers;

import com.myApp.rest.webservices.restful_web_services.data.ToDo;
import com.myApp.rest.webservices.restful_web_services.service.ToDoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class ToDoController {

    @Autowired
    ToDoHardCodedService toDoHardCodedService;

    @GetMapping("/{username}/todos")
    public List<ToDo> getAllToDos(){
        return toDoHardCodedService.findAll();
    }



    @DeleteMapping("/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        ToDo toDo = toDoHardCodedService.deleteById(id);
        if(toDo != null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{username}/todos/{id}")
    public ToDo getToDo(@PathVariable String username, @PathVariable long id){
        return toDoHardCodedService.findById(id);
    }

    @PutMapping("/{username}/todos/{id}")
    public ResponseEntity<ToDo> updateDo(@PathVariable String username, @PathVariable long id,@RequestBody ToDo todo){
        ToDo todoUpdated = toDoHardCodedService.save(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/{username}/todos/{id}")
    public ResponseEntity<Void> saveToDo(@PathVariable String username, @PathVariable long id,@RequestBody ToDo todo){
        ToDo todoCreated = toDoHardCodedService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
