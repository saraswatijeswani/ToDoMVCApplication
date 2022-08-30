package com.todo.repository;

import com.todo.model.ToDo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class ToDoRepository {

    private final Map<Integer,ToDo> toDoHashMap = new HashMap<>();

    public Optional<ToDo> getTodo(int toDoId) {
        return Optional.ofNullable(this.toDoHashMap.getOrDefault(toDoId, null));
    }

    public List<ToDo> getAllToDos() {
        return new ArrayList<>(toDoHashMap.values());
    }

    public Optional<ToDo> addToDo(ToDo toDo) {
        if(!toDoHashMap.containsKey(toDo.getToDoId())) {
            toDoHashMap.put(toDo.getToDoId(), toDo);
        } else {
            return Optional.empty();
        }
        return this.toDoHashMap.values().stream().filter(todo1 -> todo1.getToDoId() == toDo.getToDoId()).findFirst();
    }

    public Boolean deleteToDo(ToDo toDo) {
        return toDoHashMap.remove(toDo.getToDoId(), toDo);
    }

    public Optional<ToDo> setStatus(ToDo toDo){
        toDo.setStatus("Completed");
        ToDo updatedToDo = toDoHashMap.put(toDo.getToDoId(),toDo);
        return Optional.ofNullable(updatedToDo);

    }
}
