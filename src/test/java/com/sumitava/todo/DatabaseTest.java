package com.sumitava.todo;

import com.sumitava.todo.db.entity.TodoItem;
import com.sumitava.todo.db.repo.TodoItemRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class DatabaseTest {
    @Autowired
    private TodoItemRepo todoItemRepo;

    @Test
    public void testSave(){
        TodoItem todo = new TodoItem();
        todo.setTitle("Hello World");
        todo.setStartDate(new Date());
        todoItemRepo.save(todo);
    }
}
