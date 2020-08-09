package dev.ericksuarez.task.management.service.service;

import dev.ericksuarez.task.management.service.model.Task;
import dev.ericksuarez.task.management.service.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findTask(String id) {
        // TODO create custom exception
        log.info("event=findTask id={}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task id not found: " + id));
    }

    public Task newTask(Task task) {
        var taskToSave = task.toBuilder().done(false).build();
        log.info("event=newTaskInvoked taskToSave={}", taskToSave);
        return taskRepository.save(taskToSave);
    }

    public Task updateTask(Task task, String id) {
        var taskToUpdate = task.toBuilder().id(id).build();
        log.info("event=updateTaskInvoked taskToUpdate={}", taskToUpdate);
        return taskRepository.save(taskToUpdate);
    }

    public Task completeTask(String id) {
        log.info("event=completeTaskInvoked id={}", id);
        return patchTask(id, completeTask);
    }

    public Task undoTask(String id) {
        log.info("event=undoTaskInvoked id={}", id);
        return patchTask(id, undoTask);
    }

    public ResponseEntity deleteTask(String id) {
        log.info("event=deleteTaskInvoked id={}", id);
        var taskToDelete = findTask(id);
        taskRepository.delete(taskToDelete);
        return ResponseEntity.ok().build();
    }

    private Function<Task, Task> completeTask = task -> task.toBuilder().done(true).build();
    private Function<Task, Task> undoTask = task -> task.toBuilder().done(true).build();

    private Task patchTask(String id, Function<Task, Task> patch) {
        return taskRepository.findById(id)
                .map(patch)
                .map(task -> taskRepository.save(task))
                .orElseThrow(() -> new RuntimeException("error"));
    }
}
