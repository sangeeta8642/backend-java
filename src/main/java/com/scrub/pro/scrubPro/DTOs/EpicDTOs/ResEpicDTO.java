package com.scrub.pro.scrubPro.DTOs.EpicDTOs;

import com.scrub.pro.scrubPro.DTOs.StoryDTOs.ResStoryDTO;

import java.util.List;

public class ResEpicDTO {
    private int id;
    private String title;
    private List<ResStoryDTO> stories;

    public ResEpicDTO() {
    }

    public ResEpicDTO(int id, String title, List<ResStoryDTO> stories) {
        this.id = id;
        this.title = title;
        this.stories = stories;
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

    public List<ResStoryDTO> getStories() {
        return stories;
    }

    public void setStories(List<ResStoryDTO> stories) {
        this.stories = stories;
    }

}
