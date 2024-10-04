package com.toyproject.jobadream.corp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.toyproject.jobadream.corp.dto.CorpDto;

import com.toyproject.jobadream.corp.entity.Corp;

import com.toyproject.jobadream.corp.repository.CorpRepository;
import com.toyproject.jobadream.corp.repository.JobRepository;
import com.toyproject.jobadream.corp.repository.JobUrlRepository;

import org.springframework.stereotype.Service;


@Service
public class SpecificService {

	private final CorpRepository corpRepository;
	private final JobRepository jobRepository;
	private final JobUrlRepository jobUrlRepository;


	public SpecificService(CorpRepository corpRepository, JobRepository jobRepository,
		JobUrlRepository jobUrlRepository) {
		this.corpRepository = corpRepository;
		this.jobRepository = jobRepository;
		this.jobUrlRepository = jobUrlRepository;
	}

	public CorpDto getSpecificCorp(String id) {
		Optional<Corp> optionalCorp = corpRepository.findById(id);

		if (optionalCorp.isEmpty()) {
			throw new RuntimeException("Corporation not found");
		}

		Corp corp = optionalCorp.get();
		CorpDto corpDto = new CorpDto();

		// Corp 엔티티의 기본 정보 설정
		corpDto.setId(corp.getId());
		corpDto.setName(corp.getName());

		// Job 리스트를 가져와서 DTO로 변환
		List<CorpDto.JobDto> jobDtos = jobRepository.findById(id).stream()
			.map(job -> {
				CorpDto.JobDto jobDto = new CorpDto.JobDto();
				jobDto.setId(job.getId());
				jobDto.setCorpName(job.getCorpName());
				jobDto.setTitle(job.getTitle());
				jobDto.setPosition(job.getPosition());

				// 각 Job의 URL 리스트를 가져와서 DTO로 변환
				List<CorpDto.JobDto.JobUrlDto> jobUrlDtos = jobUrlRepository.findById(id).stream()
					.map(jobUrl -> {
						CorpDto.JobDto.JobUrlDto jobUrlDto = new CorpDto.JobDto.JobUrlDto();
						jobUrlDto.setId(jobUrl.getId());
						jobUrlDto.setPlatformName(jobUrl.getPlatformName());
						jobUrlDto.setUrl(jobUrl.getUrl());
						return jobUrlDto;
					})
					.collect(Collectors.toList());

				// Job에 URL 리스트 추가
				jobDto.setJobUrls(jobUrlDtos);
				return jobDto;
			})
			.collect(Collectors.toList());

		// CorpDto에 Job 리스트 추가
		corpDto.setJobs(jobDtos);

		return corpDto;
	}

}
