package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments,Integer> {
}
