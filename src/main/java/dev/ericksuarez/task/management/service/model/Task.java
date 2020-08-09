package dev.ericksuarez.task.management.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
    private Object assignedTo;
    private Object createdBy;
    private Date dueDate;
    private boolean done;
    private Object project;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
