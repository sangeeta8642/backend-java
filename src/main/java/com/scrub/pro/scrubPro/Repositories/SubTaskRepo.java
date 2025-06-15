package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Board;
import com.scrub.pro.scrubPro.Models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubTaskRepo extends JpaRepository<SubTask,Integer> {

    @Query("SELECT s FROM SubTask s WHERE s.story.StoryId = :storyId")
    List<SubTask> findByStoryId(@Param("storyId") int storyId);
}
