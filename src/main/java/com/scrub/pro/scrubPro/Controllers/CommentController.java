package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.CommentsDTOs.CreateCommentDTO;
import com.scrub.pro.scrubPro.Models.Comments;
import com.scrub.pro.scrubPro.Services.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comments> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public Comments getComment(@PathVariable int commentId) {
        return commentService.getComment(commentId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Comments>> createComment(@Valid @RequestBody CreateCommentDTO dto) {
        Comments created = commentService.createComment(dto);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Comment Created", created));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<ApiResponseDTO<Comments>> updateComment(
            @PathVariable int commentId,
            @Valid @RequestBody CreateCommentDTO dto) {
        Comments updated = commentService.updateComment(commentId, dto);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Comment Updated", updated));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment Deleted Successfully");
    }
}
