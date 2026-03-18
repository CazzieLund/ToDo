package com.example.kanban.controller;

import java.util.List;

import com.example.kanban.dto.column.ColumnResponse;
import com.example.kanban.dto.column.CreateColumnRequest;
import com.example.kanban.dto.column.UpdateColumnRequest;

import org.springframework.http.HttpStatus;
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
    public ColumnResponse updateColumn(@PathVariable Long id, @RequestBody UpdateColumnRequest request) {
        return columnService.updateColumn(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteColumn(@PathVariable Long id) {
        columnService.deleteColumn(id);
    }

    @GetMapping("/{id}")
    public List<ColumnResponse> getColumById(@PathVariable Long id) {
        return columnService.getColumnById(id);
    }
}
