package dev.ericksuarez.task.management.service.service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import dev.ericksuarez.task.management.service.service.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {

    Flux<Task> findAllByStatus (String status);
    Mono<Task> findFirstByTitle (Mono<String> title);
}
