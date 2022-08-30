package com.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDo {

    private int toDoId;
    private String toDoName;

    private String status;

    @Override
    public String toString() {
        return "ToDo{" +
                "toDoId=" + toDoId +
                ", toDoName='" + toDoName + '\'' +
                ", toDoCompleted=" + status +
                '}';
    }
}
