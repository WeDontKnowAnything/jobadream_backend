package com.toyproject.jobadream.corp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.toyproject.jobadream.corp.dto.CorpDto;

import com.toyproject.jobadream.corp.dto.JobUrlDto;
import com.toyproject.jobadream.corp.dto.JobsDto;
import com.toyproject.jobadream.corp.entity.Corp;

import com.toyproject.jobadream.corp.entity.JobUrl;
import com.toyproject.jobadream.corp.entity.Jobs;
import com.toyproject.jobadream.corp.repository.CorpRepository;
import com.toyproject.jobadream.corp.repository.JobRepository;
import com.toyproject.jobadream.corp.repository.JobUrlRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.SneakyThrows;

@Service
public class SpecificCorpSearchService {

	private final CorpRepository corpRepository;
	private final JobRepository jobRepository;
	private final JobUrlRepository jobUrlRepository;

	public SpecificCorpSearchService(CorpRepository corpRepository, JobRepository jobRepository,
		JobUrlRepository jobUrlRepository) {
		this.corpRepository = corpRepository;
		this.jobRepository = jobRepository;
		this.jobUrlRepository = jobUrlRepository;
	}

	// 특정기업 ID로 조회하기
	@SneakyThrows
	@Transactional(readOnly = true)
	public CorpDto getSpecificCorps(String corpId) {
		Corp corp = corpRepository.findById(corpId).orElseThrow(() -> new Exception("존재하지 않는 회사 ID입니다."));

		CorpDto corpDto = new CorpDto();
		corpDto.setId(corp.getId());
		corpDto.setName(corp.getName());

		List<Jobs> jobs = jobRepository.findByCorpId(corpId);

		var jobsDtos = jobs.stream().map(job -> {
			JobsDto jobsDto = new JobsDto();
			jobsDto.setCorpId(corp.getId());
			jobsDto.setCorpName(job.getCorpName());
			jobsDto.setPosition(job.getPosition());
			jobsDto.setTitle(job.getTitle());

			List<JobUrl> jobUrls = jobUrlRepository.findByJobId(job.getId());

			var jobUrlDtos = jobUrls.stream().map(jobUrl -> {
				JobUrlDto jobUrlDto = new JobUrlDto();
				jobUrlDto.setPlatformName(jobUrl.getPlatformName());
				jobUrlDto.setUrl(jobUrl.getUrl());
				return jobUrlDto;
			}).collect(Collectors.toList());

			jobsDto.setJobUrls(jobUrlDtos);
			return jobsDto;
		}).collect(Collectors.toList());
		// 여기수정함
		corpDto.setJobs(jobsDtos);
		return corpDto;
	}

}
