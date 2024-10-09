package com.toyproject.jobadream.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.jobadream.bbs.dto.CommentDto;
import com.toyproject.jobadream.bbs.service.CommentService;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/all")
	public List<CommentDto> getAllComments() {
		return commentService.getAllComments();
	}

	@GetMapping("/Specific")
	public CommentDto getCommentById(@RequestParam("Id") Integer commentId) {
		return commentService.getCommentById(commentId);
	}

}
