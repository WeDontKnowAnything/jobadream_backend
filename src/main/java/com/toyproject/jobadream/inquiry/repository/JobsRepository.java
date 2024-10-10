package com.toyproject.jobadream.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyproject.jobadream.inquiry.entity.JobsEntity;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity, Long> {
	@Query("SELECT j FROM JobsEntity j WHERE j.location = :location AND j.position = :position " +
		"AND (j.id LIKE %:keyword% OR j.corpName LIKE %:keyword% OR j.title LIKE %:keyword%)")
	List<JobsEntity> findByLocationAndPositionAndKeyword(@Param("location") String location,
		@Param("position") String position,
		@Param("keyword") String keyword);
}