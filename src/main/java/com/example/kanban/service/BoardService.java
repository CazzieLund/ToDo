package com.example.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
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
        .map(board ->
            new BoardResponse(
                board.getId(),
                board.getName()
            )
        )
        .toList();
    }

    public BoardResponse createBoard(CreateBoardRequest request) {

        Board board = new Board();
        board.setName(request.getName());

        Board saved = boardRepository.save(board);

        return new BoardResponse(
            saved.getId(),
            saved.getName()
        );
    }

}