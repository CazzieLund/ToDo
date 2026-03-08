package com.example.kanban.repository;

import com.example.kanban.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryn extends JpaRepository<Task,Long> {


}
