package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.StoryStatusDTOs.CreateStoryStatusDTO;
import com.scrub.pro.scrubPro.Services.StoryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story-status")
public class StoryStatusController {

    @Autowired
    private StoryStatusService service;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CreateStoryStatusDTO>> create(@RequestBody CreateStoryStatusDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Story status created", service.create(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CreateStoryStatusDTO>> getById(@PathVariable int id) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Story status found", service.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<CreateStoryStatusDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "All story statuses", service.getAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CreateStoryStatusDTO>> update(@PathVariable int id, @RequestBody CreateStoryStatusDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Story status updated", service.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Object>> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Story status deleted", null));
    }
}
