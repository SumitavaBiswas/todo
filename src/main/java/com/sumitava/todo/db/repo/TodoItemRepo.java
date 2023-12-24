package com.sumitava.todo.db.repo;

import com.sumitava.todo.db.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoItemRepo extends JpaRepository<TodoItem, Long> {

    @Query("select p.id from TodoItem p")
    List<Integer> getAllIds();
}
