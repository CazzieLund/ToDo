package com.example.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.column.ColumnResponse;
import com.example.kanban.dto.column.CreateColumnRequest;
import com.example.kanban.model.BoardColumn;
import com.example.kanban.repository.ColumnRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColumnService {

    private final ColumnRepository columnRepository;

    public ColumnService(ColumnRepository columnRepository){
        this.columnRepository = columnRepository;
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

        BoardColumn column = new BoardColumn();
        column.setName(request.getName());

        BoardColumn saved = columnRepository.save(column);

        return new ColumnResponse(
            saved.getId(),
            saved.getName(),
            saved.getBoard().getId()
        );
    }
    
}
