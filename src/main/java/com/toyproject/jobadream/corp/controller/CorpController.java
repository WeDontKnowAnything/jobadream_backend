package com.toyproject.jobadream.corp.controller;

import com.toyproject.jobadream.corp.dto.CorpDto;
import com.toyproject.jobadream.corp.service.CorpService;
import com.toyproject.jobadream.corp.service.SpecificService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/corporation")
public class CorpController {

	private final CorpService corpService;
	private final SpecificService specificService;

	public CorpController(CorpService corpService, SpecificService specificService) {
		this.corpService = corpService;
		this.specificService = specificService;
	}

	// 전체 회사 조회
	@GetMapping("/all")
	public List<CorpDto> readAllCorporations() {
		return corpService.getAllCorporations();
	}

	// 특정 회사 조회
	@GetMapping("/specific")
	public CorpDto readCorporation(@RequestParam("id") String id) {
		return specificService.getSpecificCorp(id);
	}
}
