package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.Title = :title")
    Optional<Role> findByTitle(@Param("title") String email);
}
