package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Repositories.SprintRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    private final SprintRepo sprintRepo;

    public SprintService(SprintRepo sprintRepo) {
        this.sprintRepo = sprintRepo;
    }

    public List<Sprint> getAllSprints() {
        return sprintRepo.findAll();
    }

    public Sprint getSprint(int sprintId) {
        return sprintRepo.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    public Sprint createSprint(CreateSprintDTO sprintDTO) {

        Sprint sprint = new Sprint();
        sprint.setSprintNo(sprintDTO.getSprintNo());
        sprint.setSprintName(sprintDTO.getSprintName());  // Correct property assignment
        sprint.setSprintPoint(sprintDTO.getSprintPoint());
        sprint.setEndDate(sprintDTO.getEndDate());
        sprint.setStartDate(sprintDTO.getStartDate());

        return sprintRepo.save(sprint);
    }

    public Sprint updateSprint(int sprintId, CreateSprintDTO sprintDTO) {
        Sprint sprint = sprintRepo.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));

        sprint.setSprintNo(sprintDTO.getSprintNo());
        sprint.setSprintName(sprintDTO.getSprintName());  // Correct property assignment
        sprint.setSprintPoint(sprintDTO.getSprintPoint());
        sprint.setEndDate(sprintDTO.getEndDate());
        sprint.setStartDate(sprintDTO.getStartDate());

        return sprintRepo.save(sprint);
    }

    public boolean deleteSprint(int sprintId) {
        if (!sprintRepo.existsById(sprintId)) {
            throw new RuntimeException("Sprint not found");
//            return false;
        }
        sprintRepo.deleteById(sprintId);
        return true;
    }

}
