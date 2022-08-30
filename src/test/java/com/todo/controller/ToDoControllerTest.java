package com.todo.controller;


import com.todo.model.ToDo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.todo.ToDoMVCApplicationTest;

import java.util.List;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ToDoControllerTest extends ToDoMVCApplicationTest {

    @Mock
    private ToDoController toDoController;

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
    public void testGetToDoById() throws Exception {
        ToDo doModel = new ToDo(111,"Saraswati","Completed");
        Mockito.when(toDoController.getToDoById(111)).thenReturn(doModel);
        ToDo toDo = toDoController.getToDoById(111);
        verify(toDoController, times(1)).getToDoById(anyInt());
        Assert.assertEquals(toDo.getToDoName(), doModel.getToDoName());
    }

    @Test
    public void testGetAllToDos() throws Exception {
        Mockito.when(toDoController.getAllToDos()).thenReturn(toDoList);
        List<ToDo> listResult = toDoController.getAllToDos();
        Assert.assertEquals(toDoList, listResult);
    }

    @Test
    public void testAddToDo() throws Exception {
        ToDo toDo = new ToDo(666,"Mukesh","Completed");
        Mockito.when(toDoController.addToDo(any())).thenReturn(toDo);
        ToDo toDoResult = toDoController.addToDo(toDo);
        Assert.assertEquals(toDoResult.getToDoName(), toDo.getToDoName());
    }

    @Test
    public void testDeleteToDo() throws Exception {
        ToDo toDo = new ToDo(666,"Mukesh","Completed");
        Mockito.when(toDoController.deleteToDo(any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        toDoController.deleteToDo(toDo.getToDoId());
        verify(toDoController, times(1)).deleteToDo(toDo.getToDoId());
    }

    @Test
    public void testSetStatus() throws Exception {
        ToDo toDo = new ToDo(666,"Mukesh","Completed");
        Mockito.when(toDoController.setStatus(any())).thenReturn(toDo);
        ToDo toDoResult = toDoController.setStatus(toDo);
        Assert.assertEquals(toDoResult.getStatus(), toDo.getStatus());
    }
}
