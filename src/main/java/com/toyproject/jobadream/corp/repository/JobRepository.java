package com.toyproject.jobadream.corp.repository;

import java.util.List;

import com.toyproject.jobadream.corp.entity.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, String> {
	List<Jobs> findByCorpId(String corpId);
}
