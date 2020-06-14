package dev.ericksuarez.task.management.service.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericksuarez.task.management.service.service.TaskManagementService;

@RestController
public class TaskController {

    private TaskManagementService taskManagementService;

    @Autowired
    public TaskController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }

    @GetMapping("/")
    public String home() {
        taskManagementService.test();
        return "ok";
    }

    @GetMapping("/ok")
    public String home2() {
        return "ok";
    }
}
