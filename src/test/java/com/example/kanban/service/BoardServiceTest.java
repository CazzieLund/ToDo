package com.example.kanban.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
import com.example.kanban.exception.BoardNotFoundException;
import com.example.kanban.model.Board;
import com.example.kanban.repository.BoardRepository;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    void getBoardById_shouldReturnBoardResponse_whenBoardExists() {
        Board board = new Board(
                1L,
                "Test3");

        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));

        BoardResponse response = boardService.getBoardById(1L);

        assertEquals("Test3", response.getName());
    }

    @Test
    void getBoardById_shouldThrowBoardNotFoundException_whenBoardDoesNotExist() {
        when(boardRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                BoardNotFoundException.class,
                () -> boardService.getBoardById(1L));
    }

    @Test
    void createBoard_shouldSaveAndReturnBoard() {
        CreateBoardRequest request = new CreateBoardRequest(
                "Test5");

        Board saveBoard = new Board(
                1L,
                "Test5");

        when(boardRepository.save(any(Board.class))).thenReturn(saveBoard);

        BoardResponse response = boardService.createBoard(request);

        assertEquals("Test5", response.getName());
        verify(boardRepository, times(1)).save(any(Board.class));
    }

    @Test
    void deleteBoard_shouldDeleteBoard_whenBoardExists() {
        Board board = new Board(1L, "Test");

        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));

        boardService.deleteBoard(1L);

        verify(boardRepository).delete(board);
    }

    @Test
    void deleteBoard_shouldThrowBoardNotFoundException_whenBoardDoesNotExist() {
        when(boardRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                BoardNotFoundException.class,
                () -> boardService.deleteBoard(1L));

        verify(boardRepository, never()).delete(any(Board.class));
    }
}
