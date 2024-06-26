package com.myApp.rest.webservices.restful_web_services.service;

import com.myApp.rest.webservices.restful_web_services.data.ToDo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToDoHardCodedService {

    private static List<ToDo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static{
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to Microservices",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to Angular",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to Azure",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to Aws",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to Architect design",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to AI",new Date(),true));
        todos.add(new ToDo(idCounter++,"codeWithDipti","Learn to AWS",new Date(),true));
    }

    public List<ToDo> findAll(){
        return todos;
    }

    public ToDo deleteById(long id){
        ToDo toDo = findById(id);
        if(toDo == null) return null;
        if(todos.remove(toDo))
            return toDo;
        return null;
    }

    public ToDo findById(long id) {
        for(ToDo todo : todos){
            if(id==todo.getId())
                return todo;
        }
        return null;

    }

    public ToDo save(ToDo todo){
        if(todo.getId()==-1){
            todo.setId(idCounter++);
            todos.add(todo);
        }else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }


}
