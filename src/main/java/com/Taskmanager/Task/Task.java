package com.Taskmanager.Task;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task {

    @Id
    private String id;
    private String text;

    public Task() {}

    public Task(String text) {
        this.text = text;
    }

    public String getId() { return id; }
    public String getText() { return text; }

    public void setId(String id) { this.id = id; }
    public void setText(String text) { this.text = text; }
}