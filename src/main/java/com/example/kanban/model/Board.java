package com.example.kanban.model;

import jakarta.persistence.*;

/**
 * Represents a Kanban board.
 * 
 * A board contains multiple columns and acts as the root
 * entity in the Kanban domain model.
 */
@Entity
public class Board {

    /**
     * Primary key of the board.
     * Auto-generated using MySQL identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the board.
     * Cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Default constructor required by JPA.
     */
    public Board() {}

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
    
}
