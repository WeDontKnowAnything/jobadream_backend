package com.toyproject.jobadream.corp.repository;

import java.util.List;

import com.toyproject.jobadream.corp.entity.JobUrl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobUrlRepository extends JpaRepository<JobUrl, String> {
	List<JobUrl> findByJobId(String jobId);
}
