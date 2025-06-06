package com.scrub.pro.scrubPro.DTOs.BoardDTOs;

public class CreateBoardDTO {
    private String BoardName;

    public CreateBoardDTO(String boardName) {
        BoardName = boardName;
    }

    public String getBoardName() {
        return BoardName;
    }

    public void setBoardName(String boardName) {
        BoardName = boardName;
    }
}
