package com.scrub.pro.scrubPro.DTOs.StoryDTOs;

import com.scrub.pro.scrubPro.Models.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateStoryDTO {

    @NotNull
    @Size(max = 100)
    private String StoryName;

    @NotNull
    @Size(max = 255)
    private String Description;

    @NotNull
    private boolean Flag;

    @NotNull
    private StoryStatus StatusId;

    @NotNull
    private Board BoardId;

    @NotNull
    private Users UserId;

    @NotNull
    private Sprint SprintId;

    @NotNull
    private Epic EpicId;

    public CreateStoryDTO(String storyName, String description, boolean flag, StoryStatus statusId, Board boardId, Users userId, Sprint sprintId, Epic epicId) {
        StoryName = storyName;
        Description = description;
        Flag = flag;
        StatusId = statusId;
        BoardId = boardId;
        UserId = userId;
        SprintId = sprintId;
        EpicId = epicId;
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
