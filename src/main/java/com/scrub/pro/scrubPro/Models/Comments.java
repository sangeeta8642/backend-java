package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Comments")
public class Comments {

    public Comments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CommentId;

    @NotNull
    @Size(max = 100)
    private String Comment;

    @ManyToOne
    @JoinColumn(name = "StoryId", referencedColumnName = "StoryId")
    private Story story;

    public Comments(int commentId, String Comment, Story story) {
        CommentId = commentId;
        Comment = Comment;
        this.story = story;
    }

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int commentId) {
        CommentId = commentId;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        Comment = Comment;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
