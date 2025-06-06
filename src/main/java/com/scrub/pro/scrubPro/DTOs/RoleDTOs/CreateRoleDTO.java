package com.scrub.pro.scrubPro.DTOs.RoleDTOs;

public class CreateRoleDTO {
    private String title;


    public CreateRoleDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
