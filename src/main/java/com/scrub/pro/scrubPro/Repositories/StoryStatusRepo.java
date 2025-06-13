package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.StoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoryStatusRepo extends JpaRepository<StoryStatus,Integer> {
    Optional<StoryStatus> findByName(String name);
}
