package com.example.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.board.BoardDetailsResponse;
import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
import com.example.kanban.dto.board.UpdateBoardRequest;
import com.example.kanban.dto.column.ColumnWithTasksResponse;
import com.example.kanban.dto.task.TaskSummaryResponse;
import com.example.kanban.exception.BoardNotFoundException;
import com.example.kanban.model.Board;
import com.example.kanban.repository.BoardRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse(
                        board.getId(),
                        board.getName()))
                .toList();
    }

    public BoardResponse createBoard(CreateBoardRequest request) {

        Board board = new Board();
        board.setName(request.getName());

        Board saved = boardRepository.save(board);

        return new BoardResponse(
                saved.getId(),
                saved.getName());
    }

    public BoardResponse updateBoard(Long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));

        board.setName(request.getName());

        Board updated = boardRepository.save(board);

        return new BoardResponse(
                updated.getId(),
                updated.getName());
    }

    public BoardResponse getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));

        return new BoardResponse(
                board.getId(),
                board.getName()
        );
    }

    @Transactional(readOnly = true)
    public BoardDetailsResponse getBoardDetails(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        return new BoardDetailsResponse(
                board.getId(),
                board.getName(),
                board.getColumns().stream()
                        .map(column -> new ColumnWithTasksResponse(
                                column.getId(),
                                column.getName(),
                                column.getTasks().stream()
                                        .map(task -> new TaskSummaryResponse(
                                                task.getId(),
                                                task.getName(),
                                                task.getDescription()))
                                        .toList()))
                        .toList());
    }

}