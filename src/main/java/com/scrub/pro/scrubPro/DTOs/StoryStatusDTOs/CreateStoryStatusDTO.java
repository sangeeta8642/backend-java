package com.scrub.pro.scrubPro.DTOs.StoryStatusDTOs;
public class CreateStoryStatusDTO {
//    private int id;
    private String name;

    public CreateStoryStatusDTO() {}

    public CreateStoryStatusDTO(int id, String name) {
//        this.id = id;
        this.name = name;
    }

    // Getters & setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
