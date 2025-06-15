package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StoryId;

    @NotNull
    @Size(max = 100)
    private String StoryName;

    @Size(max = 255)
    private String Description;

    private boolean Flag = false;

    // Relations

    @ManyToOne
    @JoinColumn(name = "StatusId", referencedColumnName = "Id")
    private StoryStatus status;


//    @ManyToOne
//    @JoinColumn(name = "BoardId", referencedColumnName = "BoardId")
//    private Board board;
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "SprintId", referencedColumnName = "SprintId")
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name = "EpicId", referencedColumnName = "EpicId")
    private Epic epic;

    // Getters and setters


    public int getStoryId() {
        return StoryId;
    }

    public void setStoryId(int storyId) {
        StoryId = storyId;
    }

    public String getStoryName() {
        return StoryName;
    }

    public void setStoryName(String storyName) {
        StoryName = storyName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isFlag() {
        return Flag;
    }

    public void setFlag(boolean flag) {
        Flag = flag;
    }

    public StoryStatus getStatus() {
        return status;
    }

    public void setStatus(StoryStatus status) {
        this.status = status;
    }

//    public Board getBoard() {
//        return board;
//    }
//
//    public void setBoard(Board board) {
//        this.board = board;
//    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}
