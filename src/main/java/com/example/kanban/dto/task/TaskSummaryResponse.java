package com.example.kanban.dto.task;

public record TaskSummaryResponse(
        Long id,
        String name,
        String description
) {}
