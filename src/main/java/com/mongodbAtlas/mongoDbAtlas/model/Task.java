package com.mongodbAtlas.mongoDbAtlas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@AllArgsConstructor @NoArgsConstructor @Data
public class Task {
    @Id
    private String taskId;
    private String description;
    private int severity;
    private String assignee;
    private  int storyPoint;

}
