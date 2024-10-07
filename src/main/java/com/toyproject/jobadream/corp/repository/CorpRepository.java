package com.toyproject.jobadream.corp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyproject.jobadream.corp.entity.Corp;

public interface CorpRepository extends JpaRepository<Corp, String> {
}
