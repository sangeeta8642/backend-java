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
    private StoryStatus StatusId;

    @ManyToOne
    @JoinColumn(name = "BoardId", referencedColumnName = "BoardId")
    private Board BoardId;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    private Users UserId;

    @ManyToOne
    @JoinColumn(name = "SprintId", referencedColumnName = "SprintId")
    private Sprint SprintId;

    @ManyToOne
    @JoinColumn(name = "EpicId", referencedColumnName = "EpicId")
    private Epic EpicId;

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

    public StoryStatus getStatusId() {
        return StatusId;
    }

    public void setStatusId(StoryStatus statusId) {
        StatusId = statusId;
    }

    public Board getBoardId() {
        return BoardId;
    }

    public void setBoardId(Board boardId) {
        BoardId = boardId;
    }

    public Users getUserId() {
        return UserId;
    }

    public void setUserId(Users userId) {
        UserId = userId;
    }

    public Sprint getSprintId() {
        return SprintId;
    }

    public void setSprintId(Sprint sprintId) {
        SprintId = sprintId;
    }

    public Epic getEpicId() {
        return EpicId;
    }

    public void setEpicId(Epic epicId) {
        EpicId = epicId;
    }
}
