package com.example.kanban.model;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.*;

/**
 * Represents a column within a Kanban board.
 * 
 * Each column belongs to exactly one Board.
 */
@Entity
@Table(name = "board_column") 
public class BoardColumn {
    
    /**
     * Primary key of the column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the column.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The board this column belongs to.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks(){
        return tasks;
    }

    public void setTasks(List<Task> tasks){
        this.tasks= tasks;
    }

    /**
     * Returns the board ID.
     */
    public Long getId(){
        return id;
    }

    /**
     * Returns the board name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the board name.
     * 
     * @param name the name of the board
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the board
     * 
     * @param board the board
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
