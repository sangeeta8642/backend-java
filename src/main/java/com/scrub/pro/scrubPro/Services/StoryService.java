package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.DTOs.StoryDTOs.CreateStoryDTO;
import com.scrub.pro.scrubPro.DTOs.StoryDTOs.ResStoryDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Enums.StoryStatusType;
import com.scrub.pro.scrubPro.Exceptions.ResourceNotFoundException;
import com.scrub.pro.scrubPro.Models.*;
import com.scrub.pro.scrubPro.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {
    private final StoryRepo storyRepo;
    private final BoardRepo boardRepo;
    private final UserRepo userRepo;
    private final SprintRepo sprintRepo;
    private final EpicRepo epicRepo;
    private final StoryStatusRepo statusRepo;

    public StoryService(StoryRepo storyRepo,
                        BoardRepo boardRepo,
                        UserRepo userRepo,
                        SprintRepo sprintRepo,
                        EpicRepo epicRepo,
                        StoryStatusRepo statusRepo) {
        this.storyRepo = storyRepo;
        this.boardRepo = boardRepo;
        this.userRepo = userRepo;
        this.sprintRepo = sprintRepo;
        this.epicRepo = epicRepo;
        this.statusRepo = statusRepo;
    }

    public List<Story> getAllStories() {
        return storyRepo.findAll();
    }

    public Story getStory(int storyId) {
        return storyRepo.findById(storyId)
                .orElseThrow(() -> new RuntimeException("Story not found"));
    }

    public Story createStory(CreateStoryDTO storyDTO) {

        Users user = userRepo.findById(storyDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        StoryStatus status = statusRepo.findById(storyDTO.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status Not Found"));

//        Board board = boardRepo.findById(storyDTO.getBoardId())
//                .orElseThrow(() -> new RuntimeException("Board Not Found"));

        Sprint sprint = sprintRepo.findById(storyDTO.getSprintId())
                .orElseThrow(() -> new RuntimeException("Sprint Not Found"));

        Epic epic = epicRepo.findById(storyDTO.getEpicId())
                .orElseThrow(() -> new RuntimeException("Epic Not Found"));

        Story story = new Story();
        story.setStoryName(storyDTO.getStoryName());
        story.setDescription(storyDTO.getDescription());
        story.setFlag(storyDTO.isFlag());
//        story.setBoard(board);
        story.setSprint(sprint);
        story.setEpic(epic);
        story.setStatus(status);
        story.setUsers(user);

        return storyRepo.save(story);
    }


    public Story updateStory(int storyId, CreateStoryDTO storyDTO) {
        Story story = storyRepo.findById(storyId)
                .orElseThrow(() -> new RuntimeException("Story not found"));

        Users user = userRepo.findById(storyDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        StoryStatus status = statusRepo.findById(storyDTO.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status Not Found"));

//        Board board = boardRepo.findById(storyDTO.getBoardId())
//                .orElseThrow(() -> new RuntimeException("Board Not Found"));

        Sprint sprint = sprintRepo.findById(storyDTO.getSprintId())
                .orElseThrow(() -> new RuntimeException("Sprint Not Found"));

        Epic epic = epicRepo.findById(storyDTO.getEpicId())
                .orElseThrow(() -> new RuntimeException("Epic Not Found"));

        story.setStoryName(storyDTO.getStoryName());
        story.setDescription(storyDTO.getDescription());
        story.setFlag(storyDTO.isFlag());
//        story.setBoard(board);
        story.setSprint(sprint);
        story.setEpic(epic);
        story.setStatus(status);
        story.setUsers(user);

        return storyRepo.save(story);
    }

    public boolean deleteStory(int storyId) {
        if (!storyRepo.existsById(storyId)) {
            throw new RuntimeException("Story not found");
//            return false;
        }
        storyRepo.deleteById(storyId);
        return true;
    }

    public Story updateStoryStatus(int storyId, String statusName) {
        Story story = storyRepo.findById(storyId)
                .orElseThrow(() -> new ResourceNotFoundException("Story not found"));

        StoryStatusType statusEnum = StoryStatusType.fromString(statusName);

        StoryStatus status = statusRepo.findByName(statusEnum.name())
                .orElseThrow(() -> new ResourceNotFoundException("Status not found"));

        story.setStatus(status);
        return storyRepo.save(story);
    }

    private ResStoryDTO mapToDTO(Story story) {
        ResStoryDTO dto = new ResStoryDTO();
        dto.setId(story.getStoryId());
        dto.setTitle(story.getStoryName());
        dto.setStatus(story.getStatus().getName());
        return dto;
    }
}
