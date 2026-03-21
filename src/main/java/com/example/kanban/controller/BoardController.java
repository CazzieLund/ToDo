package com.example.kanban.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.kanban.dto.board.BoardDetailsResponse;
import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
import com.example.kanban.dto.board.UpdateBoardRequest;
import com.example.kanban.service.BoardService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getAllBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@Valid @RequestBody CreateBoardRequest request) {
        BoardResponse createdBoard = boardService.createBoard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoard);
    }

    @PutMapping("/{id}")
    public BoardResponse updateBoard(@PathVariable Long id, @Valid @RequestBody UpdateBoardRequest request) {
        return boardService.updateBoard(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/{id}")
    public BoardResponse getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @GetMapping("/{id}/details")
    public BoardDetailsResponse getBoardDetails(@PathVariable Long id) {
        return boardService.getBoardDetails(id);
    }

}
