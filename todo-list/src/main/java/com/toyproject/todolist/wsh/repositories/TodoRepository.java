package com.toyproject.todolist.wsh.repositories;

import com.toyproject.todolist.wsh.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Test, Long> {
}
