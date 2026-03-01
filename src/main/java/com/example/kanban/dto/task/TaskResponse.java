package com.example.kanban.dto.task;

public class TaskResponse {
    private Long id;
    private String name;
    private String description;
    private Long columnId;

    public TaskResponse(){}

    public TaskResponse(Long id, String name, String description, Long columnId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.columnId = columnId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getColumnId() {
        return columnId;
    }
}
