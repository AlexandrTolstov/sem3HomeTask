package com.example.sem3HomeTask.service;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private NotificationService notificationService;
    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public User createUser(String name, int age, String email) {
        User user = new User(name, age, email);
// Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
