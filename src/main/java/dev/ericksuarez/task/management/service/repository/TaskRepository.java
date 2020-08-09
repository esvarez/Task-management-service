package dev.ericksuarez.task.management.service.repository;

import dev.ericksuarez.task.management.service.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
