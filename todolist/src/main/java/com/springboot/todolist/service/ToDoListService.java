package com.springboot.todolist.service;

import java.util.List;

import com.springboot.todolist.domain.todolist.ToDoList;
import com.springboot.todolist.web.dto.ToDoListDto;

public interface ToDoListService {

	public List<ToDoList> getList();
	public boolean addToDo(ToDoListDto toDoListDto);
	public boolean modifyToDo(int id, ToDoListDto toDoListDto);
	public boolean removeToDo(int id);
}
