package com.toyproject.jobadream.bbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toyproject.jobadream.bbs.entity.CommentEntity;
import com.toyproject.jobadream.bbs.entity.PostEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	// PostEntity를 기준으로 댓글 조회
	List<CommentEntity> findByPost(PostEntity post);
}
