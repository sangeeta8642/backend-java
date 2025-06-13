package com.scrub.pro.scrubPro.Repositories;

import com.scrub.pro.scrubPro.Models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpicRepo extends JpaRepository<Epic,Integer> {
   }
