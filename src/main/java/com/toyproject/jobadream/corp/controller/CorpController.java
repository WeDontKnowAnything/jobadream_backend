package com.toyproject.jobadream.corp.controller;

import com.toyproject.jobadream.corp.dto.CorpDto;
import com.toyproject.jobadream.corp.service.AllCorpListService;
import com.toyproject.jobadream.corp.service.SpecificCorpSearchService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/corporation")
public class CorpController {

	private final AllCorpListService allCorpListService;
	private final SpecificCorpSearchService specificCorpSearchService;

	public CorpController(AllCorpListService allCorpListService, SpecificCorpSearchService specificCorpSearchService) {
		this.allCorpListService = allCorpListService;
		this.specificCorpSearchService = specificCorpSearchService;
	}

	// 전체 회사 조회
	@GetMapping("/all")
	public List<CorpDto> readAllCorporations() {
		return allCorpListService.getAllCorporations();
	}

	// 특정 회사 조회
	@GetMapping("/specific")
	public CorpDto readCorporation(@RequestParam("id") String id) {
		return specificCorpSearchService.getSpecificCorps(id);
	}

}
