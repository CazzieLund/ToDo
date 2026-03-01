package com.example.kanban.dto.board;

import jakarta.validation.constraints.NotBlank;

public class UpdateBoardRequest {

    @NotBlank
    private String name;

    public UpdateBoardRequest() {}

    public UpdateBoardRequest (String name)  {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
