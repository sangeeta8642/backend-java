package com.scrub.pro.scrubPro.DTOs.ReleaseDTOs;

public class CreateReleaseDTO {

    private int releaseId;
    private String releaseName;
    private int sprintId;


    public CreateReleaseDTO() {
    }

    public CreateReleaseDTO(int releaseId, String releaseName, int sprintId) {
        this.releaseId = releaseId;
        this.releaseName = releaseName;
        this.sprintId = sprintId;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

}
