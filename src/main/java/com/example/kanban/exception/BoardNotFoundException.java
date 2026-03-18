package com.example.kanban.exception;

public class BoardNotFoundException extends RuntimeException {
    
    public BoardNotFoundException(Long id) {
        super("Board with id " + id + " not found");
    }
    
}
