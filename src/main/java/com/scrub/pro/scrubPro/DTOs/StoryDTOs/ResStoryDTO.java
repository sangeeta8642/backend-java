package com.scrub.pro.scrubPro.DTOs.StoryDTOs;

public class ResStoryDTO {
    private int id;
    private String title;
    private String status;

    public ResStoryDTO(int id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public ResStoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
