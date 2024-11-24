package com.example.service2;

import com.example.service2.DatabaseEntities.User;
import com.example.service2.Repositories.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final UserService userService;

    public ConsumerService(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "example-queue") // Укажите имя очереди
    public void receiveMessage(String message) {
        System.out.println("Получено сообщение: " + message);

        // Допустим, сообщение содержит имя пользователя
        if (!userService.isUserExists(message)) {
            userService.registerNewUser(message);
            System.out.println("Пользователь зарегистрирован: " + message);
        } else {
            System.out.println("Пользователь уже существует: " + message);
        }
    }
}