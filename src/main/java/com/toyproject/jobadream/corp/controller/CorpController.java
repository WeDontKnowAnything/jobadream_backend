package com.toyproject.jobadream.corp.controller;

import com.toyproject.jobadream.corp.dto.CorpDto;
import com.toyproject.jobadream.corp.service.CorpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/corporation")
public class CorpController {

	private final CorpService corpService;

	public CorpController(CorpService corpService) {
		this.corpService = corpService;
	}

	// 전체 회사 조회
	@GetMapping("/all")
	public List<CorpDto> readAllCorporations() {
		return corpService.getAllCorporations();
	}

	// 특정 회사 조회
	@GetMapping("/Specific")
	public CorpDto readCorporation(@RequestParam("Id") String corpId) {
		return corpService.getSpecificCorp(corpId);
	}
}
