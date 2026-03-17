package com.example.kanban.exception;

public class BoardNotFoundException extends RuntimeException {
    
    public BoardNotFoundException(Long id) {
        super("Borard with id " + id + " not found");
    }
    
}
