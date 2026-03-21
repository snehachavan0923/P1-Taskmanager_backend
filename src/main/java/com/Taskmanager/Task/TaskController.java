package com.Taskmanager.Task;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}