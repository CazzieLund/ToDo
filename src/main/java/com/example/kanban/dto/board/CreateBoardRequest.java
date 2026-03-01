package com.example.kanban.dto.board;

import jakarta.validation.constraints.NotBlank;

public class CreateBoardRequest {

    @NotBlank
    private String name;

    public CreateBoardRequest(){}

    public CreateBoardRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
