package com.toyproject.jobadream.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toyproject.jobadream.bbs.entity.BbsEntity;

@Repository
public interface BbsRepository extends JpaRepository<BbsEntity, Long> {
}
