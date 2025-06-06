package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {

    //    Optional<Users> findByEmail(String email);
    @Query("SELECT u FROM Users u WHERE u.Email = :email")
    Optional<Users> findByEmail(@Param("email") String email);

    @Query("SELECT COUNT(u) > 0 FROM Users u WHERE u.Email = :email")
    boolean existingByEmail(@Param("email") String email);


}
