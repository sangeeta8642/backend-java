package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "SubTask")
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskId;

    @NotNull
    @Size(max = 100)
    private String TaskName;

    @NotNull
    @Size(max = 255)
    private String Description;

    @ManyToOne
    @JoinColumn(name = "StoryId", referencedColumnName = "StoryId")
    private Story story;

    public SubTask(int taskId, String taskName, String description, Story story) {
        TaskId = taskId;
        TaskName = taskName;
        Description = description;
        this.story = story;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
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

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
