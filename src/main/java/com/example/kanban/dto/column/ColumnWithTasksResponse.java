package com.example.kanban.dto.column;

import java.util.List;

import com.example.kanban.dto.task.TaskSummaryResponse;

public record ColumnWithTasksResponse(
        Long id,
        String name,
        List<TaskSummaryResponse> tasks
) {}
