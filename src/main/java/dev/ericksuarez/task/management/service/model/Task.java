package dev.ericksuarez.task.management.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    //private Object user;
}
