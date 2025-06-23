package com.scrub.pro.scrubPro.DTOs.StoryDTOs;

public class ResStoryDTO {
    private int id;
    private String title;
    private String status;
    private String userName;
    private String des;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ResStoryDTO(int id, String title, String status, String userName, String des) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.userName=userName;
        this.des=des;
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
