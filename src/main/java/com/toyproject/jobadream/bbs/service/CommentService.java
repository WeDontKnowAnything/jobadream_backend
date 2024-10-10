package com.toyproject.jobadream.bbs.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.dto.CommentDto;
import com.toyproject.jobadream.bbs.entity.CommentEntity;
import com.toyproject.jobadream.bbs.entity.PostEntity;
import com.toyproject.jobadream.bbs.repository.CommentRepository;
import com.toyproject.jobadream.bbs.repository.PostRepository;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	// 댓글 목록 조회 메소드
	public List<CommentDto> getCommentsByPostId(Integer postId) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		List<CommentEntity> comments = commentRepository.findByPost(post);

		return comments.stream().map(comment -> {
			CommentDto dto = new CommentDto();
			dto.setId(comment.getId());
			dto.setComment(comment.getComment());
			dto.setCommentDate(comment.getCommentDate());
			dto.setPostId(comment.getPost().getId());
			return dto;
		}).collect(Collectors.toList());
	}

	// 새로운 댓글 작성 메소드
	public CommentDto createComment(Integer postId, String comment) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setComment(comment);
		commentEntity.setPost(post);
		commentEntity.setCommentDate(LocalDateTime.now());
		commentRepository.save(commentEntity);

		CommentDto commentDto = new CommentDto();
		commentDto.setId(commentEntity.getId());
		commentDto.setComment(comment);
		commentDto.setPostId(postId);
		commentDto.setCommentDate(commentEntity.getCommentDate());

		return commentDto;
	}

	// 댓글 수정 메소드
	public Object updateComment(Integer postId, Integer commentId, String content) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		CommentEntity comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new IllegalArgumentException("Comment not found"));

		LocalDateTime modifiedDate = LocalDateTime.now();

		comment.setComment(content);
		comment.setCommentDate(modifiedDate);
		commentRepository.save(comment);

		return Map.of(
			"comment-id", comment.getId(),
			"post-id", postId,
			"content", comment.getComment(),
			"comment-date", modifiedDate,
			"modified-date", modifiedDate
		);
	}

	// 댓글 삭제 메소드
	public String deleteComment(Integer postId, Integer commentId) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		CommentEntity comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new IllegalArgumentException("Comment not found"));

		commentRepository.delete(comment);
		return "댓글이 성공적으로 삭제되었습니다.";
	}
}
