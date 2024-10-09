package com.toyproject.jobadream.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyproject.jobadream.bbs.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
