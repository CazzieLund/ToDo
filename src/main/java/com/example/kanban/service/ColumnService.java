package com.example.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.column.UpdateColumnRequest;
import com.example.kanban.dto.column.ColumnResponse;
import com.example.kanban.dto.column.CreateColumnRequest;
import com.example.kanban.model.Board;
import com.example.kanban.model.BoardColumn;
import com.example.kanban.repository.BoardRepository;
import com.example.kanban.repository.ColumnRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColumnService {

    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public ColumnService(ColumnRepository columnRepository, BoardRepository boardRepository){
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<ColumnResponse> getAllColumns() {
        return columnRepository.findAll()
        .stream()
        .map(column ->
            new ColumnResponse(
                column.getId(),
                column.getName(),
                column.getBoard().getId()
            )
        )
        .toList();
    }

    public ColumnResponse createColumn(CreateColumnRequest request) {

        Board board = boardRepository.findById(request.getBoardId())
            .orElseThrow(() -> new RuntimeException("Board not found"));

        BoardColumn column = new BoardColumn();
        column.setName(request.getName());
        column.setBoard(board);

        BoardColumn saved = columnRepository.save(column);

        return new ColumnResponse(
            saved.getId(),
            saved.getName(),
            saved.getBoard().getId()
        );
    }

        public ColumnResponse updateColumn(Long id, UpdateColumnRequest request) {
        BoardColumn column = columnRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found"));

        column.setName(request.getName());

        BoardColumn updated = columnRepository.save(column);

        return new ColumnResponse(
            updated.getId(),
            updated.getName(),
            updated.getBoard().getId()
        );
    }
    
}
