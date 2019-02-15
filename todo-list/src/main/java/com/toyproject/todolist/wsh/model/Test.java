package com.toyproject.todolist.wsh.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String todo;

	public Test() {
	}

	public Test(String todo) {
		this.todo = todo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Test)) return false;
		Test todo1 = (Test) o;
		return Objects.equals(id, todo1.id) &&
				Objects.equals(todo, todo1.todo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, todo);
	}

	@Override
	public String toString() {
		return "Test{" +
				"id=" + id +
				", todo='" + todo + '\'' +
				'}';
	}

	public void editTodo(String editedTodo) {
		this.todo = editedTodo;
	}
}
