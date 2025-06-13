package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Sprint;
import com.scrub.pro.scrubPro.Models.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryRepo extends JpaRepository<Story, Integer> {
    @Query("SELECT s FROM Story s WHERE s.sprint.SprintId = :sprintId")
    List<Story> findBySprintCustom(@Param("sprintId") int sprintId);


}
