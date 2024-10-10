package com.toyproject.jobadream.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toyproject.jobadream.inquiry.entity.JobsUrlEntity;

@Repository
public interface JobsUrlsRepository extends JpaRepository<JobsUrlEntity, String> {
	List<JobsUrlEntity> findByJobId(String jobId);
}