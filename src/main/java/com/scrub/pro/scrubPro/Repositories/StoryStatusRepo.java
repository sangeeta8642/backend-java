package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.StoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryStatusRepo extends JpaRepository<StoryStatus,Integer> {
}
