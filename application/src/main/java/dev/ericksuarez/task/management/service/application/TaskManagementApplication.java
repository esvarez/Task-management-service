package dev.ericksuarez.task.management.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericksuarez.task.management.service.service.TestService;

@RestController
@SpringBootApplication(scanBasePackages = "dev.ericksuarez.task.management.service")
public class TaskManagementApplication {

	private final TestService testService;

	public TaskManagementApplication(TestService testService) {
		this.testService = testService;
	}

	@GetMapping("/")
	public String home() {
		return testService.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
