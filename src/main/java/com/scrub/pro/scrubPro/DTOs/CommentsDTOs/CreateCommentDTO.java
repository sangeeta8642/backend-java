package com.scrub.pro.scrubPro.DTOs.CommentsDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCommentDTO {

    @NotNull
    @Size(max = 100)
    private String comment;

    @NotNull
    private int storyId;

    public CreateCommentDTO() {}

    public CreateCommentDTO(String comment, int storyId) {
        this.comment = comment;
        this.storyId = storyId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
}

