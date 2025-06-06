package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Release")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ReleaseId;

    @NotNull
    @Size(min = 4, max = 100, message = "Release name must contain at least 4 characters")
    private String ReleaseName;


    @ManyToOne
    @JoinColumn(name = "SprintId", nullable = false,referencedColumnName = "SprintId")
    private Sprint sprint;

    public Release(int releaseId, String releaseName) {
        ReleaseId = releaseId;
        ReleaseName = releaseName;
    }

    public int getReleaseId() {
        return ReleaseId;
    }

    public void setReleaseId(int releaseId) {
        ReleaseId = releaseId;
    }

    public String getReleaseName() {
        return ReleaseName;
    }

    public void setReleaseName(String releaseName) {
        ReleaseName = releaseName;
    }


    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }


}
