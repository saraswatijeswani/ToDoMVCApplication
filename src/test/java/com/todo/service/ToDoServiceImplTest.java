package com.todo.service;

import com.todo.*;
import com.todo.model.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ToDoServiceImplTest extends ToDoMVCApplicationTest {

    @Mock
    private ToDoServiceImpl toDoService;

    private final List<ToDo> toDoList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        ToDo firstModel = new ToDo(111, "Saraswati", "Completed");
        ToDo secondModel = new ToDo(222, "Suvarna", "Pending");
        ToDo thirdModel = new ToDo(333, "Ankit", "Completed");
        ToDo fourthModel = new ToDo(444, "Shubhada", "Pending");
        toDoList.add(firstModel);
        toDoList.add(secondModel);
        toDoList.add(thirdModel);
        toDoList.add(fourthModel);
    }

    @Test
    public void testGetAllToDos() {
        when(toDoService.getAllToDos()).thenReturn(toDoList);
        List<ToDo> todos = toDoService.getAllToDos();
        assertNotNull(todos);
        verify(toDoService, times(1)).getAllToDos();
    }

    @Test
    public void testAddToDo() {
        ToDo toDo = new ToDo(666, "MUKESH", "Completed");
        when(toDoService.addToDo(any())).thenReturn(Optional.of(toDo));
        Optional<ToDo> toDoMock = toDoService.addToDo(toDo);
        assertNotNull(toDoMock);
        assertEquals("MUKESH", toDoMock.get().getToDoName());
    }

    @Test
    public void testDeleteToDo() {
        ToDo toDo = new ToDo(666, "MUKESH", "Completed");
        boolean result = toDoService.deleteToDo(toDo.getToDoId());
        assertFalse(result);
        verify(toDoService, times(1)).deleteToDo(anyInt());
    }

}
