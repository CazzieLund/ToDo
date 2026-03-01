package com.example.kanban.dto.column;

import com.example.kanban.model.Board;

public class ColumnResponse {

    private Long id;
    private String name;
    private Long boardId;

    public ColumnResponse() {}

    public ColumnResponse(Long id, String name, Long boardId) {
        this.id = id;
        this.name = name;
        this.boardId = boardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long boardId() {
        return boardId;
    }

    public void setBoardId() {
        this.boardId = boardId;
    }
}
