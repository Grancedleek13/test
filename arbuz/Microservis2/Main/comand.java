package com.example.service2;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommandService {

    private final ActivityRepository activityRepository;
    private final RestTemplate restTemplate;

    public CommandService(ActivityRepository activityRepository, RestTemplate restTemplate) {
        this.activityRepository = activityRepository;
        this.restTemplate = restTemplate;
    }

    public String sendCommandToService3(String command) {
        try {
            String response = restTemplate.postForObject("http://microservice-3/execute", command, String.class);
            logActivity(command, response);
            return response;
        } catch (Exception e) {
            logActivity(command, "Ошибка: " + e.getMessage());
            return "Ошибка при выполнении команды: " + e.getMessage();
        }
    }

    private void logActivity(String command, String result) {
        Activity activity = new Activity();
        activity.setCommand(command);
        activity.setResult(result);
        activityRepository.save(activity);
    }
}