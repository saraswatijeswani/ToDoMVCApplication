package com.todo.service;

import com.todo.model.ToDo;
import com.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDos() {
        return toDoRepository.getAllToDos();
    }

    @Override
    public Optional<ToDo> getToDoById(int toDoId) {
        return toDoRepository.getTodo(toDoId);
    }

    @Override
    public Optional<ToDo> addToDo(ToDo toDo) {
        return toDoRepository.addToDo(toDo);

    }

    @Override
    public Boolean deleteToDo(int toDoId) {
        Optional<ToDo> todoResult = getToDoById(toDoId);
        if (todoResult.isPresent()) {
            return toDoRepository.deleteToDo(todoResult.get());
        }
        return false;
    }

    @Override
    public Optional<ToDo> setStatus(ToDo toDo) {
        if(toDoRepository.getTodo(toDo.getToDoId()).isPresent()){
            return toDoRepository.setStatus(toDo);
        }
        return Optional.of(toDo);
    }

}
