package com.toyproject.jobadream.bbs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.bbs.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 모든 포스트 요청(Get 방식)
	@GetMapping("/post/all")
	public ResponseEntity<List<PostDto>> getAllPosts() {
		List<PostDto> postDtos = postService.getAllPosts();
		return new ResponseEntity<>(postDtos, HttpStatus.OK); // 200 OK 응답
	}

	// 특정 게시물 조회 메소드 (Get 방식)
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto post = postService.getPostById(postId);
		return ResponseEntity.ok(post);
	}

	// 게시글 작성 (Post 방식)
	@PostMapping("/post")
	public ResponseEntity<PostDto> createPost(@RequestParam String title, @RequestParam String content) {
		PostDto postDto = new PostDto();
		postDto.setTitle(title);
		postDto.setContent(content);

		PostDto createdPost = postService.createPost(postDto);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED); // 201 Created 응답
	}

	// 게시글 수정 메서드 (PATCH 방식)
	@PatchMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostDto postDto) {
		if (postDto.getTitle() == null || postDto.getContent() == null) {
			return ResponseEntity.badRequest().build(); // 400 Bad Request 응답
		}

		PostDto updatedPost = postService.updatePost(postId, postDto);
		return new ResponseEntity<>(updatedPost, HttpStatus.OK); // 200 OK 응답
	}

	// 댓글 삭제 기능 (Delete 요청)
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<String> deleteComment(@PathVariable("postId") Integer postId) {
		String message = postService.deletePost(postId);
		return ResponseEntity.ok(message);
	}
}
