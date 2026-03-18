package com.example.kanban.controller;

import com.example.kanban.dto.board.BoardResponse;
import com.example.kanban.dto.board.CreateBoardRequest;
import com.example.kanban.exception.BoardNotFoundException;
import com.example.kanban.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private BoardService boardService;

    @Test
    void getAllBoards_shouldReturn200() throws Exception {
        BoardResponse board = new BoardResponse(1L, "TestBoard");

        when(boardService.getAllBoards()).thenReturn(List.of(board));

        mockMvc.perform(get("/api/boards"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createBoard_shouldReturn201_whenBodyIsValid() throws Exception {
        CreateBoardRequest request = new CreateBoardRequest("TestBoard2");
        BoardResponse response = new BoardResponse(1L, "TestBoard2");

        when(boardService.createBoard(any(CreateBoardRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/boards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void createBoard_shouldReturn400_whenNameIsBlank() throws Exception {
        CreateBoardRequest request = new CreateBoardRequest("");

        mockMvc.perform(post("/api/boards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getBoardById_shouldReturn404_whenBoardDoesNotExist() throws Exception {
        when(boardService.getBoardById(99L))
                .thenThrow(new BoardNotFoundException(99L));

        mockMvc.perform(get("/api/boards/99"))
                .andDo(print());
    }
}