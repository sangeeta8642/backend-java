package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {

    @Query("SELECT COUNT(s) > 0 FROM Sprint s WHERE s.SprintNo = :sprintNo")
    boolean existsBySprintNo(@Param("sprintNo") String sprintNo);

    @Query("SELECT COUNT(s) > 0 FROM Sprint s " +
            "WHERE s.StartDate <= :endDate AND s.EndDate >= :startDate")
    boolean existsByDateRangeOverlap(@Param("startDate") Date startDate,
                                     @Param("endDate") Date endDate);

    @Query("SELECT s FROM Sprint s WHERE s.board.BoardId = :boardId")
    List<Sprint> findByBoardId(@Param("boardId") int boardId);

    @Query("SELECT s FROM Sprint s WHERE s.board.BoardId = :boardId AND :today BETWEEN s.StartDate AND s.EndDate")
    Sprint findActiveSprint(@Param("boardId") Long boardId, @Param("today") Date today);
}
