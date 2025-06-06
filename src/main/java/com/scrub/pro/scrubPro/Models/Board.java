package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BoardId;

    @NotNull
    @Size(max = 100,message = "Board name should not extend more than 100 characters")
    private String BoardName;

    @OneToMany(mappedBy = "board")
    private List<Story> stories;

    public Board() {
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Board(int boardId, String boardName) {
        BoardId = boardId;
        BoardName = boardName;
    }

    public int getBoardId() {
        return BoardId;
    }

    public void setBoardId(int boardId) {
        BoardId = boardId;
    }

    public String getBoardName() {
        return BoardName;
    }

    public void setBoardName(String boardName) {
        BoardName = boardName;
    }
}
