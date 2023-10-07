package com.sumitava.todo.services;

import com.sumitava.todo.db.entity.TodoItem;
import com.sumitava.todo.db.repo.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepo repo;

    public void addTodo(TodoItem todoItem){
        repo.save(todoItem);
    }
}
