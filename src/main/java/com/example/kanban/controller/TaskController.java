package com.example.kanban.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.dto.task.CreateTaskRequest;
import com.example.kanban.dto.task.TaskResponse;
import com.example.kanban.dto.task.UpdateTaskRequest;
import com.example.kanban.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
    
    @PostMapping
    public TaskResponse createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(Long id, @RequestBody UpdateTaskRequest request) {
        return taskService.updateTask(id, request);
    }
}
