package com.toyproject.todolist.wsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	List<String> todoList = new ArrayList<>();

	@GetMapping("")
	public String main(Model model) {
		model.addAttribute("todoList", todoList);
		String message = "<p>Hello World!</p>";
		model.addAttribute("message", message);
		return "main";
	}

	@PostMapping("/add")
	public String add(String todo) {
		todoList.add(todo);
		return "redirect:/";
	}

	@PostMapping("/edit/{index}")
	public String edit(String editedTodo, @PathVariable int index) {
		todoList.remove(index);
		todoList.add(editedTodo);
		return "redirect:/";
	}

	@DeleteMapping("/delete/{index}")
	public String delete(@PathVariable int index) {
		System.out.println("test : " + index);
		todoList.remove(index);
		return "redirect:/";
	}

	@PutMapping("/edit/{index}")
	public String edit(@PathVariable int index, Model model) {
		model.addAttribute("editTodo", todoList.get(index));
		model.addAttribute("index", index);
		return "reform";
	}
}
