package com.toyproject.jobadream.inquiry.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.inquiry.dto.CorporationDto;
import com.toyproject.jobadream.inquiry.dto.JobsDto;
import com.toyproject.jobadream.inquiry.service.InquiryService;

@RestController
@RequestMapping("/api/v1/search")
public class InquiryController {

	private final InquiryService inquiryService;

	public InquiryController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}

	// 기업 검색
	@GetMapping("/corporations")
	public List<CorporationDto> searchCorporations(@RequestParam("keyword") String keyword) {
		return inquiryService.searchCorporations(keyword);
	}

	// 채용 공고 검색
	@GetMapping("/jobs")
	public ResponseEntity<List<JobsDto>> searchJobs(
		@RequestParam(value = "location", required = false) String location,
		@RequestParam(value = "position", required = false) String position,
		@RequestParam(value = "keyword", required = false) String keyword) {

		List<JobsDto> jobs = inquiryService.searchJobs(location, position, keyword);
		return ResponseEntity.ok(jobs);
	}

	// 게시글 검색
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> searchPosts(@RequestParam("keyword") String keyword) {
		List<PostDto> posts = inquiryService.searchPosts(keyword);
		return ResponseEntity.ok(posts);
	}
}
