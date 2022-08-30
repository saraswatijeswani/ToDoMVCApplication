package com.todo.service;

import com.todo.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    public List<ToDo> getAllToDos();

    Optional<ToDo> getToDoById(int toDoId);

    public Optional<ToDo> addToDo(ToDo toDo);

    public Boolean deleteToDo(int toDoId);

    Optional<ToDo> setStatus(ToDo toDo);
}
