package dev.ericksuarez.task.management.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import dev.ericksuarez.task.management.service.application.controller.TaskController;
import dev.ericksuarez.task.management.service.service.TaskManagementService;
import dev.ericksuarez.task.management.service.service.repository.TaskRepository;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackageClasses = TaskRepository.class )
@ComponentScan(basePackageClasses = { TaskController.class, TaskManagementService.class })
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}
}
