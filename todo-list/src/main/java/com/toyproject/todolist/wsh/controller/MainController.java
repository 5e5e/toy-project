package com.toyproject.todolist.wsh.controller;

import com.toyproject.todolist.wsh.model.Test;
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
		List<Test> todos = todoRepository.findAll();
		model.addAttribute("todoList", todos);
		return "main";
	}

	@PostMapping("/add")
	public String add(String todo) {
		todoRepository.save(new Test(todo));
		return "redirect:/";
	}

	@PostMapping("/edit/{id}")
	public String edit(String editedTodo, @PathVariable Long id) {
		System.out.println("editedTodo= " + editedTodo);
		Optional<Test> todo = todoRepository.findById(id);
		Test test = todo.get();
		test.editTodo(editedTodo);
		todoRepository.save(test);
		return "redirect:/";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<Test> todo = todoRepository.findById(id);
		todoRepository.delete(todo.get());
		return "redirect:/";
	}

	@PutMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<Test> todo = todoRepository.findById(id);
		model.addAttribute("editTodo", todo.get());
		return "reform";
	}
}
