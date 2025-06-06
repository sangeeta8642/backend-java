package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepo extends JpaRepository<Story,Integer> {
}
