package com.example.kanban.dto.task;

import jakarta.validation.constraints.NotNull;

public record MoveTaskRequest(@NotNull Long columnId) {
}
