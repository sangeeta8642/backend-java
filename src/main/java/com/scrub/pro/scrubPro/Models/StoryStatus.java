package com.scrub.pro.scrubPro.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "StoryStatus")
public class StoryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public StoryStatus() {
    }

    @NotNull
    @Size(max = 50)
    private String name;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Story> stories;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public StoryStatus(int id, String name) {
        Id = id;
        name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

}
