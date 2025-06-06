package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.BoardDTOs.CreateBoardDTO;
import com.scrub.pro.scrubPro.Models.Board;
import com.scrub.pro.scrubPro.Services.BoardServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardServices boardServices;

    public BoardController(BoardServices boardServices) {
        this.boardServices = boardServices;
    }

    @GetMapping
    public List<Board> getAllBoards() {
        return boardServices.getAllBoards();
    }

    @GetMapping("/{boardId}")
    public Board getBoard(@PathVariable int boardId) {
        return boardServices.getBoard(boardId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Board>> createBoard(@RequestBody @Valid CreateBoardDTO dto) {
        Board createdBoard = boardServices.createBoard(dto);
        ApiResponseDTO<Board> res = new ApiResponseDTO<Board>(true, "Board Created Successfully", createdBoard);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<ApiResponseDTO<Board>> updateBoard(@PathVariable int boardId, @RequestBody @Valid CreateBoardDTO dto) {
        Board updatedBoard = boardServices.updateBoard(boardId, dto);
        ApiResponseDTO<Board> res = new ApiResponseDTO<Board>(true, "Board Update Successfully", updatedBoard);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable int boardId) {
        boolean boardDeleted = boardServices.deleteBoard(boardId);
        if (boardDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Board Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Board Deletion Failed");
    }
}
