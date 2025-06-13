package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Stagged_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaggedUserRepo extends JpaRepository<Stagged_User, Integer> {

    //    Optional<Users> findByEmail(String email);
    @Query("SELECT u FROM Stagged_User u WHERE u.Email = :email")
    Optional<Stagged_User> findByEmail(@Param("email") String email);

    @Query("SELECT COUNT(u) > 0 FROM Stagged_User u WHERE u.Email = :email")
    boolean existingByEmail(@Param("email") String email);


}
