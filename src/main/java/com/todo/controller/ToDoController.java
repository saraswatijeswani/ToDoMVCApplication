package com.todo.controller;

import com.todo.model.ToDo;
import com.todo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/toDo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    /**
     * Used to get all ToDo data
     *
     * @return List of ToDos
     */
    @GetMapping
    public List<ToDo> getAllToDos() {
        return this.toDoService.getAllToDos();
    }

    /**
     * Retrieves data using specific id
     *
     * @param toDoId
     * @return ToDo data
     */
    @GetMapping("/{toDoId}")
    public ToDo getToDoById(@PathVariable int toDoId) {
        return this.toDoService.getToDoById(toDoId).get();
    }

    /**
     * Adds toDo data
     *
     * @param toDo
     * @return added toDo data
     */
    @PostMapping()
    public ToDo addToDo(@RequestBody ToDo toDo) {
        return this.toDoService.addToDo(toDo).get();
    }

    /**
     * sets the value to completed
     *
     * @param toDo
     * @return
     */
    @PatchMapping()
    public ToDo setStatus(@RequestBody ToDo toDo) {
        return this.toDoService.setStatus(toDo).get();

    }

    /**
     * Deletes the ToDos data
     * @param toDoId
     * @return HttpStatus
     */
    @DeleteMapping("/{toDoId}")
    public ResponseEntity<Void> deleteToDo(@PathVariable int toDoId) {
        Boolean result = this.toDoService.deleteToDo(toDoId);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
