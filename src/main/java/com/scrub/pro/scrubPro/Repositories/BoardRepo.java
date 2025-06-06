package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<Board,Integer> {
}
