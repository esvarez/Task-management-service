package dev.ericksuarez.task.management.service.controller;

import dev.ericksuarez.task.management.service.model.Task;
import dev.ericksuarez.task.management.service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{taskId}")
    public Task findTaskById(@PathVariable String taskId){
        return taskService.findTaskById(taskId);
    }

    @PostMapping("/task")
    public Task newTask(@RequestBody Task task) {
        return taskService.newTask(task);
    }

    @PutMapping("/task/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task task) {
        return taskService.updateTask(task, taskId);
    }

    @PatchMapping("/completeTask/{taskId}")
    public Task completeTask(@PathVariable String taskId) {
        return taskService.completeTask(taskId);
    }

    @PatchMapping("/undoTask/{taskId}")
    public Task undoTask(@PathVariable String taskId) {
        return taskService.undoTask(taskId);
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<?> deletePost(@PathVariable String taskId) {
        return taskService.deleteTask(taskId);
    }
}
