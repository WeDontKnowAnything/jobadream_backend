package com.toyproject.jobadream.bbs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.dto.CommentDto;
import com.toyproject.jobadream.bbs.entity.CommentEntity;
import com.toyproject.jobadream.bbs.repository.CommentRepository;

@Service
public class CommentService {

	private final CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	// 전체 조회
	public List<CommentDto> getAllComments() {
		List<CommentEntity> comments = commentRepository.findAll();
		return comments.stream()
			.map(comment -> {
				CommentDto commentDto = new CommentDto();
				commentDto.setId(comment.getId());
				commentDto.setComment(comment.getComment());
				commentDto.setCommentDate(comment.getCommentDate());
				return commentDto;
			})
			.collect(Collectors.toList());
	}

	public CommentDto getCommentById(Integer commentId) {
		CommentEntity comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setComment(comment.getComment());
		commentDto.setCommentDate(comment.getCommentDate());
		return commentDto;
	}

}
