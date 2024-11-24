package com.example.service3;

import org.springframework.stereotype.Service;

@Service
public class ActivityLogService {

    public void logActivity(String command, String result) {
        // Здесь вы можете записывать информацию о командной активности в базу данных или в файл
        System.out.println("Команда: " + command);
        System.out.println("Результат: " + result);
    }
}