package com.todo.todo_app.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todo_app.Service.TodoService;
import com.todo.todo_app.model.Todo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Todo> todos = service.getTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task, Model model) {
        service.addTodo(task);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable int id) { // @PathVariable for extracting the value from the form url part
                                                     // after "/" and have to declare the /{x} in the getmapping
                                                     // annotations
        service.toggleTodo(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        service.deleteTodo(id);
        return "redirect:/";
    }

    // @GetMapping("/get-value/{x}")
    // public void printValue(PrintWriter pw, @PathVariable int x) { //@PathVariable
    // for extracting the value from the form url part after "/" and have to declare
    // the /{x} in the getmapping annotations
    // pw.println("value extracted : " + x);
    // }
}

