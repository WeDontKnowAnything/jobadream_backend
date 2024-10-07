package com.toyproject.jobadream.bbs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.jobadream.bbs.entity.BbsEntity;
import com.toyproject.jobadream.bbs.service.BbsService;

//e
@RestController
@RequestMapping("/api/v1/bbs")
public class BbsController {

	private final BbsService bbsService;

	public BbsController(BbsService bbsService) {
		this.bbsService = bbsService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<BbsEntity> getPostById(@PathVariable Long id) {
		BbsEntity post = bbsService.getPostById(id);
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(post);
	}

	@GetMapping("/all")
	public ResponseEntity<List<BbsEntity>> getAllPosts() {
		List<BbsEntity> posts = bbsService.getAllPosts();
		return ResponseEntity.ok(posts);
	}
}
