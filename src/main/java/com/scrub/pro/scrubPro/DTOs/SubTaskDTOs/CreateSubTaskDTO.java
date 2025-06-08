package com.scrub.pro.scrubPro.DTOs.SubTaskDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSubTaskDTO {

    @NotNull
    @Size(max = 100)
    private String TaskName;

    @NotNull
    @Size(max = 255)
    private String Description;

    @NotNull
    private int StoryId;

    public CreateSubTaskDTO() {}

    public CreateSubTaskDTO(String taskName, String description, int storyId) {
        TaskName = taskName;
        Description = description;
        StoryId = storyId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStoryId() {
        return StoryId;
    }

    public void setStoryId(int storyId) {
        StoryId = storyId;
    }
}
