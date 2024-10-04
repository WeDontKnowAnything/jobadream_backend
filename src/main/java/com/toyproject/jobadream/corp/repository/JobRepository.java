package com.toyproject.jobadream.corp.repository;

import com.toyproject.jobadream.corp.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, String> {
}
