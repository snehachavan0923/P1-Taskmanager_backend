package com.Taskmanager.Task;


import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/todos")
public class TaskController {

    private final TaskRepo repo; 

    public TaskController(TaskRepo repo) {
        this.repo = repo;
    }
  

    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public List<Task> saveAll(@RequestBody List<Task> todos) {
        System.out.println("POST /api/todos HIT → Saving: " + todos.size());
        return repo.saveAll(todos);
    }


    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task todo) {
        Task existing = repo.findById(id).orElseThrow();
        existing.setText(todo.getText());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}