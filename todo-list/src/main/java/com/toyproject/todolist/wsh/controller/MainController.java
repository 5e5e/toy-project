package com.toyproject.todolist.wsh.controller;

import com.toyproject.todolist.wsh.model.Todo;
import com.toyproject.todolist.wsh.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("")
	public String main(Model model) {
		List<Todo> todos = todoRepository.findAll();
		model.addAttribute("todoList", todos);
		return "main";
	}

	@PostMapping("/add")
	public String add(String todo) {
		todoRepository.save(new Todo(todo));
		return "redirect:/";
	}

	@PostMapping("/edit/{id}")
	public String edit(String editedTodo, @PathVariable int id) {
		return "redirect:/";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		todoRepository.delete(todo.get());
		return "redirect:/";
	}

	@PutMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		return "reform";
	}
}
