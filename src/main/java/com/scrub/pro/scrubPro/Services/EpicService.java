package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.EpicDTOs.CreateEpicDTO;
import com.scrub.pro.scrubPro.DTOs.SprintDTOs.CreateSprintDTO;
import com.scrub.pro.scrubPro.Models.Epic;
import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Repositories.EpicRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicService {
    private final EpicRepo epicRepo;

    public EpicService(EpicRepo epicRepo) {
        this.epicRepo = epicRepo;
    }

    public List<Epic> getAllEpics() {
        return epicRepo.findAll();
    }

    public Epic getEpic(int epicId) {
        return epicRepo.findById(epicId)
                .orElseThrow(() -> new RuntimeException("Epic not found"));
    }

    public Epic createEpic(CreateEpicDTO epicDTO) {

        Epic epic = new Epic();
        epic.setEpicName(epicDTO.getEpicName());
        epic.setDescription(epicDTO.getDescription());

        return epicRepo.save(epic);
    }

    public Epic updateEpic(int epicId, CreateEpicDTO epicDTO) {

        Epic epic = epicRepo.findById(epicId)
                .orElseThrow(() -> new RuntimeException("Epic Not Found"));

        epic.setEpicName(epicDTO.getEpicName());
        epic.setDescription(epicDTO.getDescription());

        return epicRepo.save(epic);
    }

    public boolean deleteEpic(int epicId) {
        if (!epicRepo.existsById(epicId)) {
            throw new RuntimeException("Epic not found");
//            return false;
        }
        epicRepo.deleteById(epicId);
        return true;
    }
}
