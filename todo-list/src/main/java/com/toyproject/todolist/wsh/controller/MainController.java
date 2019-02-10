package com.toyproject.todolist.wsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	List<String> todoList = new ArrayList<>();

	@GetMapping("")
	public String main(Model model) {
		model.addAttribute("todoList", todoList);
		return "main.html";
	}

	@PostMapping("/add")
	public String add(String todo) {
		todoList.add(todo);
		for (String i : todoList) {
			System.out.println("list" + i);
		}
		return "redirect:/";
	}
}
