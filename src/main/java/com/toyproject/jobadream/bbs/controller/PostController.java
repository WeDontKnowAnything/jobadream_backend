package com.toyproject.jobadream.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.bbs.service.PostService;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 전체 게시물 목록 조회 (GET 요청)
	@GetMapping("/all")
	public List<PostDto> getAllPosts() {
		return postService.getAllPosts();
	}

	// 특정 게시물 조회 (GET 요청)
	@GetMapping("/Specific")
	public PostDto getPostById(@RequestParam("Id") Integer postId) {
		return postService.getPostById(postId);
	}

	// // 새 게시물 작성 (POST 요청)
	// @PostMapping
	// public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
	// 	PostDto createdPost = postService.createPost(postDto);
	// 	return ResponseEntity.ok(createdPost);
	// }
	//
	// // 게시물 수정 (PATCH 요청)
	// @PatchMapping("/{postId}")
	// public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostDto postDto) {
	// 	PostDto updatedPost = postService.updatePost(postId, postDto);
	// 	return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build();
	// }
	//
	// // 게시물 삭제 (DELETE 요청)
	// @DeleteMapping("/{postId}")
	// public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
	// 	boolean deleted = postService.deletePost(postId);
	// 	return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	// }
}
