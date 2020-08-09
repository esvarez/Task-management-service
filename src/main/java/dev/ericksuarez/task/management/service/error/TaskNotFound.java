package dev.ericksuarez.task.management.service.error;

public class TaskNotFound extends RuntimeException {

    public TaskNotFound(String id) {
        super("Task id not found:" + id);
    }
}
