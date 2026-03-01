package com.example.kanban.dto.board;

public class BoardResponse {

    private Long id;
    private String name;

    public BoardResponse() {}

    public BoardResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
