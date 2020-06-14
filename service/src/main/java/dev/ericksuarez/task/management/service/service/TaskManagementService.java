package dev.ericksuarez.task.management.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericksuarez.task.management.service.service.model.Task;
import dev.ericksuarez.task.management.service.service.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskManagementService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskManagementService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void test() {
        var mono = taskRepository.save(Task.builder().title("new Task").build());
        System.out.println(mono.block());
        var lol = taskRepository.findAll();
        System.out.println(lol);
    }
}
