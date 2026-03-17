package com.example.kanban.exception;

public class ColumnNotFoundException extends RuntimeException {

    public ColumnNotFoundException(Long id) {
        super("Column with id " + id + " not found");
    }
    
}
