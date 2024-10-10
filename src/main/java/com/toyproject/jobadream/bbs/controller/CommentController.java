package com.toyproject.jobadream.bbs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.jobadream.bbs.dto.CommentDto;
import com.toyproject.jobadream.bbs.service.CommentService;

@RestController
@RequestMapping("/api/v1/post")
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	// 전체 댓글 목록 조회 (GET 요청)
	@GetMapping("/comments")
	public ResponseEntity<List<CommentDto>> getComments(@RequestParam("post_id") Integer postId) {
		List<CommentDto> comments = commentService.getCommentsByPostId(postId);
		return ResponseEntity.ok(comments);
	}

	// 새로운 댓글 작성(Post 요청)
	@PostMapping("/comments")
	public ResponseEntity<CommentDto> createComment(@RequestParam("post_id") Integer postId,
		@RequestParam("comment") String comment) {
		CommentDto createdComment = commentService.createComment(postId, comment);
		return ResponseEntity.ok(createdComment);
	}

	// 댓글 수정 (PATCH 요청)
	@PatchMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<Object> updateComment(@PathVariable("postId") Integer postId,
		@PathVariable("commentId") Integer commentId,
		@RequestBody CommentDto commentDto) {
		Object updatedCommentResponse = commentService.updateComment(postId, commentId, commentDto.getComment());
		return ResponseEntity.ok(updatedCommentResponse);
	}

	// 댓글 삭제 기능 (Delete 요청)
	@DeleteMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("postId") Integer postId,
		@PathVariable("commentId") Integer commentId) {
		String message = commentService.deleteComment(postId, commentId);
		return ResponseEntity.ok(message);
	}
}
