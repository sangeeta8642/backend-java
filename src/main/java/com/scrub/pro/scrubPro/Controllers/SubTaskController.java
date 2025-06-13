package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.SubTaskDTOs.CreateSubTaskDTO;
import com.scrub.pro.scrubPro.Models.SubTask;
import com.scrub.pro.scrubPro.Services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtasks")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<SubTask>> create(@RequestBody CreateSubTaskDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "SubTask created", subTaskService.createSubTask(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<SubTask>> getById(@PathVariable int id) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "SubTask found", subTaskService.getSubTask(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<SubTask>>> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "All SubTasks", subTaskService.getAllSubTasks()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<SubTask>> update(@PathVariable int id, @RequestBody CreateSubTaskDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "SubTask updated", subTaskService.updateSubTask(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Object>> delete(@PathVariable int id) {
        subTaskService.deleteSubTask(id);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "SubTask deleted", null));
    }
}

