package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.ReleaseDTOs.CreateReleaseDTO;
import com.scrub.pro.scrubPro.Exceptions.ResourceNotFoundException;
import com.scrub.pro.scrubPro.Models.Release;
import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Repositories.ReleaseRepo;
import com.scrub.pro.scrubPro.Repositories.SprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepo releaseRepo;

    @Autowired
    private SprintRepo sprintRepo;

    private CreateReleaseDTO toDTO(Release release) {
        return new CreateReleaseDTO(release.getReleaseId(), release.getReleaseName(), release.getSprint().getSprintId());
    }

    private Release toEntity(CreateReleaseDTO dto) {
        Sprint sprint = sprintRepo.findById(dto.getSprintId())
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with ID: " + dto.getSprintId()));
        Release release = new Release(dto.getReleaseId(), dto.getReleaseName());
        release.setSprint(sprint);
        return release;
    }

    public CreateReleaseDTO create(CreateReleaseDTO dto) {
        return toDTO(releaseRepo.save(toEntity(dto)));
    }

    public CreateReleaseDTO getById(int id) {
        Release release = releaseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Release not found with ID: " + id));
        return toDTO(release);
    }

    public List<CreateReleaseDTO> getAll() {
        return releaseRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CreateReleaseDTO update(int id, CreateReleaseDTO dto) {
        Release existing = releaseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Release not found with ID: " + id));
        existing.setReleaseName(dto.getReleaseName());
        Sprint sprint = sprintRepo.findById(dto.getSprintId())
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with ID: " + dto.getSprintId()));
        existing.setSprint(sprint);
        return toDTO(releaseRepo.save(existing));
    }

    public void delete(int id) {
        Release release = releaseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Release not found with ID: " + id));
        releaseRepo.delete(release);
    }
}

