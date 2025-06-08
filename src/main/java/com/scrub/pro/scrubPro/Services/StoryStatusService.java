package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.StoryStatusDTOs.CreateStoryStatusDTO;
import com.scrub.pro.scrubPro.Models.StoryStatus;
import com.scrub.pro.scrubPro.Repositories.StoryStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryStatusService {

    @Autowired
    private StoryStatusRepo repo;

    private CreateStoryStatusDTO convertToDTO(StoryStatus entity) {
        return new CreateStoryStatusDTO(entity.getId(), entity.getName());
    }

    private StoryStatus convertToEntity(CreateStoryStatusDTO dto) {
        return new StoryStatus(dto.getId(), dto.getName());
    }

    public CreateStoryStatusDTO create(CreateStoryStatusDTO dto) {
        StoryStatus entity = convertToEntity(dto);
        return convertToDTO(repo.save(entity));
    }

    public CreateStoryStatusDTO getById(int id) {
        StoryStatus entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("StoryStatus not found with id: " + id));
        return convertToDTO(entity);
    }

    public List<CreateStoryStatusDTO> getAll() {
        return repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CreateStoryStatusDTO update(int id, CreateStoryStatusDTO dto) {
        StoryStatus entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("StoryStatus not found with id: " + id));
        entity.setName(dto.getName());
        return convertToDTO(repo.save(entity));
    }

    public void delete(int id) {
        StoryStatus entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("StoryStatus not found with id: " + id));
        repo.delete(entity);
    }
}

