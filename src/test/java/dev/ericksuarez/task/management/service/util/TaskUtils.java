package dev.ericksuarez.task.management.service.util;

import dev.ericksuarez.task.management.service.model.Task;

public class TaskUtils {

    public static Task buildTask() {
        return Task.builder()
                .name("Do Task managment service")
                .build();
    }
}
