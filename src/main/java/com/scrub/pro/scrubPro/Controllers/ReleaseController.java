package com.scrub.pro.scrubPro.Controllers;


import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.ReleaseDTOs.CreateReleaseDTO;
import com.scrub.pro.scrubPro.Services.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/releases")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CreateReleaseDTO>> create(@RequestBody CreateReleaseDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Release created", releaseService.create(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CreateReleaseDTO>> getById(@PathVariable int id) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Release found", releaseService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<CreateReleaseDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "All releases", releaseService.getAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CreateReleaseDTO>> update(@PathVariable int id, @RequestBody CreateReleaseDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Release updated", releaseService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Object>> delete(@PathVariable int id) {
        releaseService.delete(id);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Release deleted", null));
    }
}
