package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")//localhost:8080/task
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    private List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/task/sort
    public List<User> sortUsersByAge(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    //Подсказка @GetMapping("/filter/{age}")

    //метод calculateAverageAge
    //Подсказка @GetMapping("/calc")
}
