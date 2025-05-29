package com.todo.todo_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // for grtter method
@Setter // for setter method
@NoArgsConstructor // for non paramitarise constructot
public class Todo {
    private int id;
    private String task;
    private boolean completed;

   
}
