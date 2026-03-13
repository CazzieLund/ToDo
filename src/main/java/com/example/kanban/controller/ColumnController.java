package com.example.kanban.controller;

import java.util.List;

import com.example.kanban.dto.column.ColumnResponse;
import com.example.kanban.dto.column.CreateColumnRequest;
import com.example.kanban.dto.column.UpdateColumnRequest;

import org.springframework.web.bind.annotation.*;

import com.example.kanban.service.ColumnService;

@RestController
@RequestMapping("api/column")
public class ColumnController {
    
    public final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping
    public List<ColumnResponse> getAllColumns() {
        return columnService.getAllColumns();
    }

    @PostMapping
    public ColumnResponse createColumn(@RequestBody CreateColumnRequest request) {
        return columnService.createColumn(request);
    }

    @PutMapping("/{id}")
    public ColumnResponse updateColumn(Long id, @RequestBody UpdateColumnRequest request) {
        return columnService.updateColumn(id, request);
    }

    @GetMapping("/{id}")
    public List<ColumnResponse> getColumById(Long id) {
        return columnService.getColumnById(id);
    }
}
