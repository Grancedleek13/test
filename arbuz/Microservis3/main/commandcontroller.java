package com.example.service3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/execute")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public String executeCommand(@RequestBody String command) {
        return commandService.processCommand(command);
    }
}