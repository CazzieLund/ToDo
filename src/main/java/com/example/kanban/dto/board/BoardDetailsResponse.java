package com.example.kanban.dto.board;

import java.util.List;

import com.example.kanban.dto.column.ColumnWithTasksResponse;

public record BoardDetailsResponse(
        Long id,
        String name,
        List<ColumnWithTasksResponse> columns
) {}
