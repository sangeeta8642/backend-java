package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.EpicDTOs.ResEpicDTO;
import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.DTOs.StoryDTOs.ResStoryDTO;
import com.scrub.pro.scrubPro.Models.*;
import com.scrub.pro.scrubPro.Repositories.BoardRepo;
import com.scrub.pro.scrubPro.Repositories.EpicRepo;
import com.scrub.pro.scrubPro.Repositories.SprintRepo;
import com.scrub.pro.scrubPro.Repositories.StoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SprintService {
    private final SprintRepo sprintRepo;
    private final EpicRepo epicRepo;
    private final StoryRepo storyRepo;
    private final BoardRepo boardRepo;

    public SprintService(SprintRepo sprintRepo, EpicRepo epicRepo, StoryRepo storyRepo, BoardRepo boardRepo) {
        this.sprintRepo = sprintRepo;
        this.epicRepo = epicRepo;
        this.storyRepo = storyRepo;
        this.boardRepo = boardRepo;
    }

    public List<Sprint> getAllSprints() {
        return sprintRepo.findAll();
    }

    public Sprint getSprint(int sprintId) {
        return sprintRepo.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

//    public Sprint createSprint(CreateSprintDTO sprintDTO) {
//
//        Sprint sprint = new Sprint();
//        sprint.setSprintNo(sprintDTO.getSprintNo());
//        sprint.setSprintName(sprintDTO.getSprintName());  // Correct property assignment
//        sprint.setSprintPoint(sprintDTO.getSprintPoint());
//        sprint.setEndDate(sprintDTO.getEndDate());
//        sprint.setStartDate(sprintDTO.getStartDate());
//
//        return sprintRepo.save(sprint);
//    }

    public Sprint createSprint(CreateSprintDTO sprintDTO) {
        // 1. Validate date range

        Board board = boardRepo.findById(sprintDTO.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("No Board found"));

        if (sprintDTO.getStartDate().after(sprintDTO.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date.");
        }

        // 2. Check for overlapping sprints
        boolean isOverlapping = sprintRepo.existsByDateRangeOverlap(
                sprintDTO.getStartDate(), sprintDTO.getEndDate()
        );

        if (isOverlapping) {
            throw new IllegalStateException("Sprint dates overlap with an existing sprint.");
        }

        // 3. Check for duplicate sprint number
        if (sprintRepo.existsBySprintNo(sprintDTO.getSprintNo())) {
            throw new IllegalArgumentException("Sprint number already exists.");
        }

        // 4. Create and save sprint
        Sprint sprint = new Sprint();
        sprint.setSprintNo(sprintDTO.getSprintNo());
        sprint.setSprintName(sprintDTO.getSprintName());
        sprint.setSprintPoint(sprintDTO.getSprintPoint());
        sprint.setStartDate(sprintDTO.getStartDate());
        sprint.setEndDate(sprintDTO.getEndDate());
        sprint.setBoard(board);

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


    public List<ResEpicDTO> getEpicsWithStories(int sprintId) {
        List<Story> storiesInSprint = storyRepo.findBySprintCustom(sprintId);

        // Group stories by epic
        Map<Epic, List<Story>> epicMap = storiesInSprint.stream()
                .collect(Collectors.groupingBy(Story::getEpic));

        List<ResEpicDTO> result = new ArrayList<>();

        for (Map.Entry<Epic, List<Story>> entry : epicMap.entrySet()) {
            Epic epic = entry.getKey();
            List<Story> stories = entry.getValue();

            ResEpicDTO epicDTO = new ResEpicDTO();
            epicDTO.setId(epic.getEpicId());
            epicDTO.setTitle(epic.getEpicName());

            List<ResStoryDTO> storyDTOs = stories.stream()
                    .map(this::mapStoryToDTO)
                    .collect(Collectors.toList());

            epicDTO.setStories(storyDTOs);
            result.add(epicDTO);
        }

        return result;
    }

    public List<Sprint> getSprintsByBoardId(int boardId) {
        return sprintRepo.findByBoardId(boardId);
    }

    public Sprint getActiveSprintByBoardId(Long boardId) {
        Date today = new Date();
        return sprintRepo.findActiveSprint(boardId, today);
    }

    private ResStoryDTO mapStoryToDTO(Story story) {
        ResStoryDTO dto = new ResStoryDTO();
        dto.setId(story.getStoryId());
        dto.setTitle(story.getStoryName());
        dto.setStatus(story.getStatus().getName());
        dto.setUserName(story.getUsers().getUserName());
        dto.setDes(story.getDescription());
        return dto;
    }

}
