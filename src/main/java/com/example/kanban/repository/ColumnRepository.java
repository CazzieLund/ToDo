package com.example.kanban.repository;

import com.example.kanban.model.BoardColumn;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnRepository extends JpaRepository<BoardColumn, Long> {
    List<BoardColumn> findByBoardId(Long boardId);
}
