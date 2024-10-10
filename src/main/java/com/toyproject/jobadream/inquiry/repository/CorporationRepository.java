package com.toyproject.jobadream.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyproject.jobadream.inquiry.entity.CorporationEntity;

@Repository
public interface CorporationRepository extends JpaRepository<CorporationEntity, Long> {

	@Query("SELECT c FROM CorporationEntity c WHERE c.name LIKE %:keyword% OR c.categoryCode = :keyword OR c.sizeCode = :keyword")
	List<CorporationEntity> findByKeyword(@Param("keyword") String keyword);
}