package com.scrub.pro.scrubPro.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Epic")
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EpicId;

    @NotNull
    @Size(max = 100,message = "Epic name should not contain more than 100 characters")
    private String EpicName;

    @NotNull
    @Size(max = 255,message = "Epic description should not contain more than 255 characters")
    private String Description;

    @OneToMany(mappedBy = "epic")
    @JsonIgnore
    private List<Story> stories;

    public Epic() {
    }

    public Epic(int epicId, String epicName, String description) {
        EpicId = epicId;
        EpicName = epicName;
        Description = description;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public int getEpicId() {
        return EpicId;
    }

    public void setEpicId(int epicId) {
        EpicId = epicId;
    }

    public String getEpicName() {
        return EpicName;
    }

    public void setEpicName(String epicName) {
        EpicName = epicName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
