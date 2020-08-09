package dev.ericksuarez.task.management.service.service;

import dev.ericksuarez.task.management.service.model.Task;
import dev.ericksuarez.task.management.service.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static dev.ericksuarez.task.management.service.util.TaskUtils.buildTask;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Nested
    @DisplayName("Test to read Tasks")
    class readTask {

        @Test
        public void getTask_idExist_returnTask() {
            final String id = "any-id";
            when(taskRepository.findById(anyString()))
                    .thenReturn(Optional.of(buildTask()));
            final var task = taskService.findTaskById(id);
            assertEquals("Do Task managment service", task.getName());
        }
    }

    @Nested
    @DisplayName("Test to save or update Tasks")
    class saveUpdateTask {

        @Test
        public void newTask_taskOkFalseDefault_returnTask() {
            final var task = buildTask();

            when(taskRepository.save(any(Task.class)))
                    .thenReturn(task.toBuilder().done(false).build());

            final var taskSaved = taskService.newTask(task);

            assertFalse(taskSaved.isDone());
        }

        @Test
        public void updateTask_taskSetId_returnTask() {
            final String idExpected = "UUID_Expected";
            final var task = buildTask();

            when(taskRepository.save(any(Task.class)))
                    .thenReturn(task.toBuilder().id(idExpected).build());

            final var taskUpdated = taskService.updateTask(task, idExpected);

            assertEquals("UUID_Expected", taskUpdated.getId());
        }

        @Test
        public void completeTask_taskComplete_returnTask() {
            final var task = buildTask();
            final String id = "task-done";

            when(taskRepository.findById(anyString()))
                    .thenReturn(Optional.of(buildTask()));
            when(taskRepository.save(any(Task.class)))
                    .thenReturn(task.toBuilder().done(true).build());

            final var taskDone = taskService.completeTask(id);

            assertTrue(taskDone.isDone());
        }

        @Test
        public void undoTask_taskUndo_returnTask() {
            final var task = buildTask();
            final String id = "task-uddone";

            when(taskRepository.findById(anyString()))
                    .thenReturn(Optional.of(buildTask()));
            when(taskRepository.save(any(Task.class)))
                    .thenReturn(task.toBuilder().done(false).build());

            final var undoTask = taskService.undoTask(id);

            assertFalse(undoTask.isDone());
        }
    }

    @Nested
    @DisplayName("Test to delete Tasks")
    class deleteTask {

        @Test
        public void deleteTask_idOk_success() {
            final String id = "task-uddone";

            when(taskRepository.findById(anyString()))
                    .thenReturn(Optional.of(buildTask()));
            ResponseEntity response = taskService.deleteTask(id);

            assertEquals(ResponseEntity.ok().build(), response);
        }
    }
}
