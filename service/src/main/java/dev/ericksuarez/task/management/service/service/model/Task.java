package dev.ericksuarez.task.management.service.service.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document
public class Task {

    @Id
    private String id;

    private String title;

    private String description;

    private TaskStatus status;

    private Date dueDate;

    private Date doneDate;

    private User assignedTo;

    private User createdBy;

    private String projectId;
}
