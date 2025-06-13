package com.scrub.pro.scrubPro.DTOs.SprintDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class CreateSprintDTO {

    @NotNull
    @Size(max = 100)
    private String SprintNo;

    @NotNull
    @Size(min = 4, max = 255, message = "Sprint name must contain at least 4 characters")
    private String SprintName;

    @NotNull
    private int SprintPoint;

    @NotNull
    private Date StartDate;

    @NotNull
    private Date EndDate;

    @NotNull
    private int boardId;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public CreateSprintDTO(String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate, int boardId) {
        SprintNo = sprintNo;
        SprintName = sprintName;
        SprintPoint = sprintPoint;
        StartDate = startDate;
        EndDate = endDate;
        this.boardId = boardId;
    }

    public String getSprintNo() {
        return SprintNo;
    }

    public void setSprintNo(String sprintNo) {
        SprintNo = sprintNo;
    }

    public String getSprintName() {
        return SprintName;
    }

    public void setSprintName(String sprintName) {
        SprintName = sprintName;
    }

    public int getSprintPoint() {
        return SprintPoint;
    }

    public void setSprintPoint(int sprintPoint) {
        SprintPoint = sprintPoint;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }
}
