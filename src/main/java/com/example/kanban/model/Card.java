package com.example.kanban.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "cards")
public class Card {
    
    /**
     * Primary key of the column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String title;

    @Size(max = 2000)
    @Column(length = 2000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "column_id", nullable = false)
    private BoardColumn column;

    public Card(){}
    
    public Card(String title, String description, BoardColumn column) {
        this.title = title;
        this.description = description;
        this.column = column;
    }

    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitel(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoardColumn getColumn() {
        return column;
    }

    public void setColumn(BoardColumn column) {
        this.column = column;
    }
}
