package com.example.kanban.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.service.BoardService;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoards();
    }

}
