package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.EpicDTOs.ResEpicDTO;
import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Services.SprintService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping
    public List<Sprint> getAllSprints() {
        return sprintService.getAllSprints();
    }

    @GetMapping("/{sprintId}")
    public Sprint getSprint(@PathVariable int sprintId) {
        return sprintService.getSprint(sprintId);
    }

    @GetMapping("/by-board/{boardId}")
    public ResponseEntity<List<Sprint>> getSprintsByBoardId(@PathVariable int boardId) {
        List<Sprint> sprints = sprintService.getSprintsByBoardId(boardId);
        return ResponseEntity.ok(sprints);
    }

//    @PostMapping
//    public ResponseEntity<ApiResponseDTO<Sprint>> createSprint(@RequestBody @Valid CreateSprintDTO dto) {
//        Sprint createdSprint = sprintService.createSprint(dto);
//        ApiResponseDTO<Sprint> res = new ApiResponseDTO<Sprint>(true, "Sprint Created Successfully", createdSprint);
//        return ResponseEntity.status(HttpStatus.OK).body(res);
//    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Sprint>> createSprint(@RequestBody @Valid CreateSprintDTO dto) {
        try {
            Sprint createdSprint = sprintService.createSprint(dto);
            ApiResponseDTO<Sprint> res = new ApiResponseDTO<>(true, "Sprint Created Successfully", createdSprint);
            return ResponseEntity.ok(res);
        } catch (IllegalArgumentException ex) {
            ApiResponseDTO<Sprint> res = new ApiResponseDTO<>(false, ex.getMessage(), null);
            return ResponseEntity.badRequest().body(res);
        } catch (Exception ex) {
            ApiResponseDTO<Sprint> res = new ApiResponseDTO<>(false, "An unexpected error occurred: "+ex.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }


    @PutMapping("/{sprintId}")
    public ResponseEntity<ApiResponseDTO<Sprint>> updateUser(@PathVariable int sprintId, @RequestBody @Valid CreateSprintDTO dto) {
        Sprint updatedSprint = sprintService.updateSprint(sprintId, dto);
        ApiResponseDTO<Sprint> res = new ApiResponseDTO<Sprint>(true, "Sprint Update Successfully", updatedSprint);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{sprintId}")
    public ResponseEntity<String> deleteUser(@PathVariable int sprintId) {
        boolean sprintDeleted = sprintService.deleteSprint(sprintId);
        if (sprintDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Sprint Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Sprint Deletion Failed");
    }

    @GetMapping("/{sprintId}/epics-with-stories")
    public ResponseEntity<ApiResponseDTO<List<ResEpicDTO>>> getEpicsWithStories(@PathVariable int sprintId) {
        List<ResEpicDTO> data = sprintService.getEpicsWithStories(sprintId);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Fetched successfully", data));
    }

    @GetMapping("/{boardId}/active-sprint")
    public ResponseEntity<ApiResponseDTO<Sprint>> getActiveSprint(@PathVariable Long boardId) {
        Sprint activeSprint = sprintService.getActiveSprintByBoardId(boardId);

        if (activeSprint != null) {
            return ResponseEntity.ok(new ApiResponseDTO<>(true, "Active sprint fetched successfully", activeSprint));
        } else {
            return ResponseEntity.ok(new ApiResponseDTO<>(false, "No active sprint found", null));
        }
    }
}
