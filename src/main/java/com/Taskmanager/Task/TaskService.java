package com.Taskmanager.Task;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepo repo;

    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public Task update(String id, Task task) {
        Task t = repo.findById(id).orElseThrow();
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setPriority(task.getPriority());
        t.setDueDate(task.getDueDate());
        t.setCategory(task.getCategory());
        t.setCompleted(task.isCompleted());
        return repo.save(t);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}