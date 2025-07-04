package com.scrub.pro.scrubPro.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sprint")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SprintId;

    @NotNull
    @Size(max = 100)
    private String SprintNo;

    @NotNull
    @Size(min = 4,max = 255, message = "Sprint name must contain at least 4 characters")
    private String SprintName;

    @NotNull
    private int SprintPoint;

    private Date StartDate;
    private Date EndDate;

    @OneToMany(mappedBy = "sprint")
    @JsonIgnore
    private List<Release> releases;

    @OneToMany(mappedBy = "sprint")
    @JsonIgnore
    private List<Story> stories;

    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
//    @com.fasterxml.jackson.annotation.JsonBackReference
    private Board board;

    public Sprint() {
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Sprint(int sprintId, String sprintNo, String sprintName, int sprintPoint, Date startDate, Date endDate, Board board) {
        SprintId = sprintId;
        SprintNo = sprintNo;
        SprintName = sprintName;
        SprintPoint = sprintPoint;
        StartDate = startDate;
        EndDate = endDate;
        this.board=board;
    }

    public int getSprintId() {
        return SprintId;
    }

    public void setSprintId(int sprintId) {
        SprintId = sprintId;
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

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}
