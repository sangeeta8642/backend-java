package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.SubTaskDTOs.CreateSubTaskDTO;
import com.scrub.pro.scrubPro.Models.Story;
import com.scrub.pro.scrubPro.Models.SubTask;
import com.scrub.pro.scrubPro.Repositories.StoryRepo;
import com.scrub.pro.scrubPro.Repositories.SubTaskRepo;
import org.springframework.stereotype.Service;

import java.lang.RuntimeException;
import java.util.List;

@Service
public class SubTaskService {

    private final SubTaskRepo subTaskRepo;
    private final StoryRepo storyRepo;

    public SubTaskService(SubTaskRepo subTaskRepo, StoryRepo storyRepo) {
        this.subTaskRepo = subTaskRepo;
        this.storyRepo = storyRepo;
    }

    public List<SubTask> getAllSubTasks() {
        return subTaskRepo.findAll();
    }

    public SubTask getSubTask(int taskId) {
        return subTaskRepo.findById(taskId)
                .orElseThrow(() -> new java.lang.RuntimeException("SubTask not found"));
    }

    public SubTask createSubTask(CreateSubTaskDTO dto) {
        Story story = storyRepo.findById(dto.getStoryId())
                .orElseThrow(() -> new java.lang.RuntimeException("Story not found"));

        SubTask subTask = new SubTask(0, dto.getTaskName(), dto.getDescription(), story);
        return subTaskRepo.save(subTask);
    }

    public SubTask updateSubTask(int taskId, CreateSubTaskDTO dto) {
        SubTask subTask = subTaskRepo.findById(taskId)
                .orElseThrow(() -> new java.lang.RuntimeException("SubTask not found"));

        Story story = storyRepo.findById(dto.getStoryId())
                .orElseThrow(() -> new java.lang.RuntimeException("Story not found"));

        subTask.setTaskName(dto.getTaskName());
        subTask.setDescription(dto.getDescription());
        subTask.setStory(story);

        return subTaskRepo.save(subTask);
    }

    public boolean deleteSubTask(int taskId) {
        if (!subTaskRepo.existsById(taskId)) {
            throw new java.lang.RuntimeException("SubTask not found");
        }
        subTaskRepo.deleteById(taskId);
        return true;
    }

    public List<SubTask> getSubTasksByStoryId(int storyId) {
        return subTaskRepo.findByStoryId(storyId);
    }
}
