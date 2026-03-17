package com.example.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.task.CreateTaskRequest;
import com.example.kanban.dto.task.TaskResponse;
import com.example.kanban.dto.task.UpdateTaskRequest;
import com.example.kanban.model.BoardColumn;
import com.example.kanban.model.Task;
import com.example.kanban.repository.ColumnRepository;
import com.example.kanban.repository.TaskRepository;

import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;

    public TaskService(TaskRepository taskRepository, ColumnRepository columnRepository) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
        .stream()
        .map(task ->
            new TaskResponse(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getColumn().getId()
            )
        )
        .toList();
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        System.out.println("****columnId:" + request.getColumnId());
         BoardColumn column = columnRepository.findById(request.getColumnId())
            .orElseThrow(() -> new RuntimeException("Column not found"));
        
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setColumn(column);

        Task saved = taskRepository.save(task);

        return new TaskResponse(
            saved.getId(),
            saved.getName(),
            saved.getDescription(),
            saved.getColumn().getId()
        );
    }

    public TaskResponse updateTask(Long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setName(request.getName());

        Task updated = taskRepository.save(task);

        return new TaskResponse(
            updated.getId(),
            updated.getName(),
            updated.getDescription(),
            updated.getColumn().getId()
        );
    }

    @Transactional(readOnly = true)
    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return new TaskResponse(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getColumn().getId()
        );
    }
}
