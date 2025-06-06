package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.EpicDTOs.CreateEpicDTO;
import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.Models.Epic;
import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Services.EpicService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epic")
public class EpicController {
    private final EpicService epicService;

    public EpicController(EpicService epicService) {
        this.epicService = epicService;
    }

    @GetMapping
    public List<Epic> getAllEpics() {
        return epicService.getAllEpics();
    }

    @GetMapping("/{epicId}")
    public Epic getEpic(@PathVariable int epicId) {
        return epicService.getEpic(epicId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Epic>> createEpic(@RequestBody @Valid CreateEpicDTO dto) {
        Epic createdEpic = epicService.createEpic(dto);
        ApiResponseDTO<Epic> res = new ApiResponseDTO<Epic>(true, "Epic Created Successfully", createdEpic);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{epicId}")
    public ResponseEntity<ApiResponseDTO<Epic>> updateUser(@PathVariable int epicId, @RequestBody @Valid CreateEpicDTO dto) {
        Epic updatedEpic = epicService.updateEpic(epicId, dto);
        ApiResponseDTO<Epic> res = new ApiResponseDTO<Epic>(true, "Epic Update Successfully", updatedEpic);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{epicId}")
    public ResponseEntity<String> deleteUser(@PathVariable int epicId) {
        boolean epicDeleted = epicService.deleteEpic(epicId);
        if (epicDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Epic Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Epic Deletion Failed");
    }
}
