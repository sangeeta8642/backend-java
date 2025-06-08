package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.BoardDTOs.CreateBoardDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Exceptions.ResourceNotFoundException;
import com.scrub.pro.scrubPro.Models.Board;
import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Repositories.BoardRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServices {

    private final BoardRepo boardRepo;

    public BoardServices(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public List<Board> getAllBoards() {
        return boardRepo.findAll();
    }

    public Board getBoard(int boardId) {
        return boardRepo.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found"));
    }

    public Board createBoard(CreateBoardDTO boardDTO) {
        Board board = new Board();
        board.setBoardName(boardDTO.getBoardName());

        return boardRepo.save(board);
    }

    public Board updateBoard(int boardId, CreateBoardDTO boardDTO) {
        Board board = boardRepo.findById(boardId).orElseThrow(() -> new RuntimeException("No Board found"));
        board.setBoardName(boardDTO.getBoardName());
        return boardRepo.save(board);
    }

    public boolean deleteBoard(int boardId) {
        if (!boardRepo.existsById(boardId)) {
            throw new RuntimeException("board not found");
//            return false;
        }
        boardRepo.deleteById(boardId);
        return true;
    }

}
