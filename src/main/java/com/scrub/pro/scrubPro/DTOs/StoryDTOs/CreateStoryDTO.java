package com.scrub.pro.scrubPro.DTOs.StoryDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateStoryDTO {

    @NotNull
    @Size(max = 100)
    private String storyName;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    private boolean flag;

    @NotNull
    private Integer statusId;

    @NotNull
    private Integer boardId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer sprintId;

    @NotNull
    private Integer epicId;

    public CreateStoryDTO() {}

    public CreateStoryDTO(String storyName, String description, boolean flag, Integer statusId, Integer boardId, Integer userId, Integer sprintId, Integer epicId) {
        this.storyName = storyName;
        this.description = description;
        this.flag = flag;
        this.statusId = statusId;
        this.boardId = boardId;
        this.userId = userId;
        this.sprintId = sprintId;
        this.epicId = epicId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }
}
