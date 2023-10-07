package com.sumitava.todo.db.repo;

import com.sumitava.todo.db.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepo extends JpaRepository<TodoItem, Long> {
}
