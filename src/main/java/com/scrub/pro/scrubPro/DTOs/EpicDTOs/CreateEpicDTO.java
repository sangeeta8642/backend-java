package com.scrub.pro.scrubPro.DTOs.EpicDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEpicDTO {
    @NotNull
    @Size(max = 100,message = "Epic name should not contain more than 100 characters")
    private String EpicName;

    @NotNull
    @Size(max = 255,message = "Epic description should not contain more than 255 characters")
    private String Description;

    public CreateEpicDTO(String epicName, String description) {
        EpicName = epicName;
        Description = description;
    }

    public String getEpicName() {
        return EpicName;
    }

    public void setEpicName(String epicName) {
        EpicName = epicName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
