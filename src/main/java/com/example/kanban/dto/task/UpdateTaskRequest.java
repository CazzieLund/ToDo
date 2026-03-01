package com.example.kanban.dto.task;

public class UpdateTaskRequest {

    private String name;
    private String description;
    private Long columnId;

    public UpdateTaskRequest(){}

    public UpdateTaskRequest(String name, String description, Long columnId) {
        this.name = name;
        this.description = description;
        this.columnId = columnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
    
}
