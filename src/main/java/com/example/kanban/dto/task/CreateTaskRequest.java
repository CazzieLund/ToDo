package com.example.kanban.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTaskRequest {

    private String name;
    private String description;

    @JsonProperty("columnId")
    private Long columnId;

    public CreateTaskRequest() {
    }

    public CreateTaskRequest(String name, String description, Long columnId) {
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