package com.springboot.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.todolist.ToDoList;
import com.springboot.todolist.domain.todolist.ToDoListRepository;
import com.springboot.todolist.web.dto.ToDoListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {

	private final ToDoListRepository toDoListRepository;
	
	@Override
	public List<ToDoList> getList(int id) {
		List<ToDoList> toDoList = toDoListRepository.getList(id);
		for(int i = 0; i < toDoList.size(); i++) {
			System.out.println("서비스-getList : " + toDoList.get(i));
		}
		if(toDoList != null) {
			return toDoList;
		}
		return null;
	}

	@Override
	public boolean addToDo(ToDoListDto toDoListDto) {
		int result = toDoListRepository.addToDo(toDoListDto.toEntity(0));
		return result != 0;
	}

	@Override
	public boolean modifyToDo(int id, ToDoListDto toDoListDto) {
		ToDoList list = toDoListDto.toEntity(id);
		int result = toDoListRepository.modifyToDo(list);
		return result != 0;
	}

	@Override
	public boolean removeToDo(int id) {
		int result = toDoListRepository.removeToDo(id);
		return result != 0;
	}

}
