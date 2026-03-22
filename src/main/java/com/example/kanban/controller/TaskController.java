package com.example.kanban.controller;

import java.util.List;

import com.example.kanban.dto.task.MoveTaskRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.dto.task.CreateTaskRequest;
import com.example.kanban.dto.task.TaskResponse;
import com.example.kanban.dto.task.UpdateTaskRequest;
import com.example.kanban.service.TaskService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping(consumes = "application/json")
    public TaskResponse createTask(@RequestBody CreateTaskRequest request) {
        System.out.println("name: " + request.getName());
        System.out.println("description: " + request.getDescription());
        System.out.println("columnId: " + request.getColumnId());

        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{taskId}/move")
    public TaskResponse moveTask(@PathVariable Long taskId,
                                 @Valid @RequestBody MoveTaskRequest request) {
        return taskService.moveTask(taskId, request);
    }
}
