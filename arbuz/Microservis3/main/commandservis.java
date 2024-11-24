package com.example.service3;

import org.springframework.stereotype.Service;

@Service
public class CommandService {

    private final ActivityLogService activityLogService;

    public CommandService(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    public String processCommand(String command) {
        // Здесь вы можете добавить логику обработки команд
        String result = "Команда " + command + " выполнена успешно.";
        
        // Логируем результат
        activityLogService.logActivity(command, result);
        
        return result;
    }
}