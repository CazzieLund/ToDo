package com.example.kanban.dto.column;

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

    public String getName() {
        return name;
    }

    public Long getBoardId() {
        return boardId;
    }
}
