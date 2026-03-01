package com.example.kanban.dto.column;

public class UpdateColumnRequest {
        private String name;
    private Long boardId;

    public UpdateColumnRequest (){}

    public UpdateColumnRequest(String name, Long boardId) {
        this.name = name;
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
