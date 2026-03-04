package com.example.kanban.repository;

import com.example.kanban.model.BoardColumn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<BoardColumn, Long> {
    
}
