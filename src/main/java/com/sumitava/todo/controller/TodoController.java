package com.sumitava.todo.controller;

import com.sumitava.todo.db.entity.TodoItem;
import com.sumitava.todo.services.TodoItemService;
import com.sumitava.todo.uitls.ApiErrors;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoItemService service;

    @CrossOrigin
    @PostMapping(value = "/add")
    public ResponseEntity<String> addTodo(@Valid @RequestBody TodoItem todo, Errors errors){
        if (errors.hasErrors()) {
            return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        service.addTodo(todo);
        return ResponseEntity.ok("User is valid");
    }


}
