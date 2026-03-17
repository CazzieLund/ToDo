package com.example.kanban.exception;

public record ErrorResponse(
    int status,
    String message
) {
    
}
