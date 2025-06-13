package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.StoryDTOs.CreateStoryDTO;
import com.scrub.pro.scrubPro.DTOs.StoryDTOs.ResStoryDTO;
import com.scrub.pro.scrubPro.DTOs.StoryStatusDTOs.UpdateStatusDTO;
import com.scrub.pro.scrubPro.Models.Story;
import com.scrub.pro.scrubPro.Services.StoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/story")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public List<Story> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/{storyId}")
    public Story getSprint(@PathVariable int storyId) {
        return storyService.getStory(storyId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Story>> createStory(@RequestBody @Valid CreateStoryDTO dto) {
        Story createdStory = storyService.createStory(dto);
        ApiResponseDTO<Story> res = new ApiResponseDTO<Story>(true, "Story Created Successfully", createdStory);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{storyId}")
    public ResponseEntity<ApiResponseDTO<Story>> updateUser(@PathVariable int storyId, @RequestBody @Valid CreateStoryDTO dto) {
        Story updatedStory = storyService.updateStory(storyId, dto);
        ApiResponseDTO<Story> res = new ApiResponseDTO<Story>(true, "Story Update Successfully", updatedStory);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{storyId}")
    public ResponseEntity<String> deleteUser(@PathVariable int storyId) {
        boolean storyDeleted = storyService.deleteStory(storyId);
        if (storyDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Story Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Story Deletion Failed");
    }

    @PatchMapping("/stories/{id}/status")
    public ResponseEntity<ApiResponseDTO<Story>> updateStoryStatus(
            @PathVariable int id,
            @RequestBody Map<String, String> body
    ) {
        String statusName = body.get("status");
        Story updated = storyService.updateStoryStatus(id, statusName);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Story status updated", updated));
    }
}
