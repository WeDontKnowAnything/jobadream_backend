package com.toyproject.jobadream.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyproject.jobadream.bbs.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
	
}
