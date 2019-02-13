package com.toyproject.todolist.wsh.repositories;

import com.toyproject.todolist.wsh.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
