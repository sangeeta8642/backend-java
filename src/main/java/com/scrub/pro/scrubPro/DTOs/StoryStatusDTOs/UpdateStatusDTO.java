package com.scrub.pro.scrubPro.DTOs.StoryStatusDTOs;

public class UpdateStatusDTO {
    private String status;

    public UpdateStatusDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
