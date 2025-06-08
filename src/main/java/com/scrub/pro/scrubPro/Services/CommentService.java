package com.scrub.pro.scrubPro.Services;


import com.scrub.pro.scrubPro.DTOs.CommentsDTOs.CreateCommentDTO;
import com.scrub.pro.scrubPro.Models.Comments;
import com.scrub.pro.scrubPro.Models.Story;
import com.scrub.pro.scrubPro.Repositories.CommentRepo;
import com.scrub.pro.scrubPro.Repositories.StoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final StoryRepo storyRepo;

    public CommentService(CommentRepo commentRepo, StoryRepo storyRepo) {
        this.commentRepo = commentRepo;
        this.storyRepo = storyRepo;
    }

    public List<Comments> getAllComments() {
        return commentRepo.findAll();
    }

    public Comments getComment(int commentId) {
        return commentRepo.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comments createComment(CreateCommentDTO dto) {
        Story story = storyRepo.findById(dto.getStoryId())
                .orElseThrow(() -> new RuntimeException("Story not found"));

        Comments comment = new Comments(0, dto.getComment(), story);
        return commentRepo.save(comment);
    }

    public Comments updateComment(int commentId, CreateCommentDTO dto) {
        Comments comment = getComment(commentId);
        Story story = storyRepo.findById(dto.getStoryId())
                .orElseThrow(() -> new RuntimeException("Story not found"));

        comment.setComment(dto.getComment());
        comment.setStory(story);

        return commentRepo.save(comment);
    }

    public boolean deleteComment(int commentId) {
        if (!commentRepo.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepo.deleteById(commentId);
        return true;
    }
}

