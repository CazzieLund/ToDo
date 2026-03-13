package com.example.kanban.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.kanban.dto.board.BoardDetailsResponse;
import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
import com.example.kanban.dto.board.UpdateBoardRequest;
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

    @PostMapping
    public BoardResponse createBoard(@RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    @PutMapping("/{id}")
    public BoardResponse updateBoard(Long id, @RequestBody UpdateBoardRequest request) {
        return boardService.updateBoard(id, request);
    }

    @GetMapping("/{id}")
    public List<BoardResponse> getBoardById(Long id) {
        return boardService.getBoardsById(id);
    }

    @GetMapping("/{id}/details")
    public BoardDetailsResponse getBoardDetails(@PathVariable Long id) {
        return boardService.getBoardDetails(id);
    }

}
