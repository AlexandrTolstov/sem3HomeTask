package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return user.toString();
    }

    @PostMapping("/registration")
    public String userRegistration(@RequestBody User user){
        service.ProcessRegistration(user.getName(), user.getAge(), user.getEmail());
        return "Новый пользователь зарегестрирован";
    }
}
