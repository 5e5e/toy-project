package com.toyproject.todolist.wsh.controller;

import com.toyproject.todolist.wsh.model.Test;
import com.toyproject.todolist.wsh.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiMainController {
	@Autowired
	private TodoRepository todoRepository;

	@PostMapping("/api/edit/{id}")
	public String apiEdit(@PathVariable Long id, String testData) {
		Test todo = todoRepository.findById(id).get();
		return "main";
	}
}
