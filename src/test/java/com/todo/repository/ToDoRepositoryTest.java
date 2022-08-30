package com.todo.repository;

import com.todo.model.ToDo;
import com.todo.ToDoMVCApplicationTest;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ToDoRepositoryTest extends ToDoMVCApplicationTest {

    @Mock
    ToDoRepository toDoRepository;

    private final List<ToDo> toDoList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        ToDo firstModel = new ToDo(111, "Saraswati", "Completed");
        ToDo secondModel = new ToDo(222, "Suvarna", "Pending");
        ToDo thirdModel = new ToDo(333, "Ankit", "Completed");
        ToDo fourthModel = new ToDo(666, "Shubhada", "Pending");
        toDoList.add(firstModel);
        toDoList.add(secondModel);
        toDoList.add(thirdModel);
        toDoList.add(fourthModel);
    }

    @Test
    public void testGetAllToDos() throws Exception {
        List<ToDo> toDos = toDoRepository.getAllToDos();
        verify(toDoRepository, times(1)).getAllToDos();
        assertNotNull(toDos);
    }

    @Test
    public void testGetTodoById() {
        Optional<ToDo> toDoFound = toDoRepository.getTodo(666);
        assertNotNull(toDoFound);
    }

    @Test
    public void testGetToDoById_notFound(){
        Optional<ToDo> todo = toDoRepository.getTodo(777);
        assertFalse(todo.isPresent());
    }

    @Test
    public void testAddToDo() throws Exception {
    Optional<ToDo> todo = toDoRepository.addToDo(new ToDo(666, "Mukesh", "Completed"));
    assertNotNull(todo);
    }


}
