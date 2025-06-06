package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Board;
import com.scrub.pro.scrubPro.Models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepo extends JpaRepository<SubTask,Integer> {
}
