package com.springboot.todolist.domain.todolist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {

	public List<ToDoList> getList();
	public int addToDo(ToDoList toDoList);
	public int modifyToDo(ToDoList toDoList);
	public int removeToDo(int id);
}
