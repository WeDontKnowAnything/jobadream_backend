package com.toyproject.jobadream.corp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.corp.dto.CorpDto;
import com.toyproject.jobadream.corp.entity.Corp;
import com.toyproject.jobadream.corp.repository.CorpRepository;

@Service
public class CorpService {

	private final CorpRepository corpRepository;

	public CorpService(CorpRepository corpRepository) {
		this.corpRepository = corpRepository;
	}

	// 전체 기업 조회 (ID, 이름)
	public List<CorpDto> getAllCorporations() {
		List<Corp> corps = corpRepository.findAll();
		return corps.stream()
			.map(corp -> {
				CorpDto corpDto = new CorpDto();
				corpDto.setId(corp.getId());
				corpDto.setName(corp.getName());
				return corpDto;
			})
			.collect(Collectors.toList());
	}

	// 특정 기업 조회 (기업 ID로 조회)
	public CorpDto getSpecificCorp(String corpId) {
		Corp corp = corpRepository.findById(Integer.valueOf(corpId))
			.orElseThrow(() -> new RuntimeException("Corporation not found with id: " + corpId));

		// Corp 엔티티를 CorpDto로 변환
		CorpDto corpDto = new CorpDto();
		corpDto.setId(corp.getId());
		corpDto.setName(corp.getName());
		corpDto.setJobs(corpDto.getJobs());

		return corpDto;
	}
}
