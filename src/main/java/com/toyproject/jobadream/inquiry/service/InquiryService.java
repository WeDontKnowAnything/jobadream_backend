package com.toyproject.jobadream.inquiry.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.bbs.entity.PostEntity;
import com.toyproject.jobadream.bbs.repository.PostRepository;
import com.toyproject.jobadream.inquiry.dto.CorporationDto;
import com.toyproject.jobadream.inquiry.dto.JobsDto;
import com.toyproject.jobadream.inquiry.dto.JobsUrlDto;
import com.toyproject.jobadream.inquiry.entity.CorporationEntity;
import com.toyproject.jobadream.inquiry.entity.JobsEntity;
import com.toyproject.jobadream.inquiry.entity.JobsUrlEntity;
import com.toyproject.jobadream.inquiry.repository.CorporationRepository;
import com.toyproject.jobadream.inquiry.repository.JobsRepository;
import com.toyproject.jobadream.inquiry.repository.JobsUrlsRepository;

@Service
public class InquiryService {

	private final CorporationRepository corporationRepository;
	private final JobsRepository jobsRepository;
	private final PostRepository postRepository;
	private final JobsUrlsRepository jobsUrlsRepository;

	public InquiryService(CorporationRepository corporationRepository, JobsRepository jobsRepository,
		PostRepository postRepository, JobsUrlsRepository jobsUrlsRepository) {
		this.corporationRepository = corporationRepository;
		this.jobsRepository = jobsRepository;
		this.postRepository = postRepository;
		this.jobsUrlsRepository = jobsUrlsRepository;
	}

	// 기업 검색
	// 기업 검색
	public List<CorporationDto> searchCorporations(String keyword) {
		List<CorporationEntity> corporations = corporationRepository.findByKeyword(keyword); // 키워드로 기업 검색

		return corporations.stream()
			.map(corp -> {
				CorporationDto dto = new CorporationDto();
				dto.setId(corp.getId());
				dto.setName(corp.getName());
				dto.setCategoryCode(corp.getCategoryCode());
				dto.setSizeCode(corp.getSizeCode());
				dto.setEmployeeCount(corp.getEmployeeCount());
				dto.setRegGender(corp.getRegGender());
				dto.setTempoGender(corp.getTempoGender());
				return dto;
			})
			.collect(Collectors.toList());
	}

	// 채용 공고 검색
	public List<JobsDto> searchJobs(String location, String position, String keyword) {
		List<JobsEntity> jobs = jobsRepository.findByLocationAndPositionAndKeyword(location, position, keyword);

		return jobs.stream()
			.map(job -> {
				JobsDto dto = new JobsDto();
				dto.setId(job.getId());
				dto.setCorpName(job.getCorpName());
				dto.setTitle(job.getTitle());
				dto.setPosition(job.getPosition());
				dto.setLocation(job.getLocation());
				dto.setOpeningDate(job.getOpeningDate());
				dto.setClosingDate(job.getClosingDate());
				dto.setCorpId(job.getCorporation().getId());

				List<JobsUrlEntity> urls = jobsUrlsRepository.findByJobId(job.getId());
				List<JobsUrlDto> urlDtos = urls.stream()
					.map(url -> {
						JobsUrlDto urlDto = new JobsUrlDto();
						urlDto.setPlatformName(url.getPlatformName());
						urlDto.setUrl(url.getUrl());
						return urlDto;
					})
					.collect(Collectors.toList());

				dto.setUrl(urlDtos);
				return dto;
			})
			.collect(Collectors.toList());
	}

	// 게시글 검색
	public List<PostDto> searchPosts(String keyword) {
		List<PostEntity> posts = postRepository.findAll();

		return posts.stream()
			.filter(post -> post.getTitle().contains(keyword))
			.map(post -> {
				PostDto dto = new PostDto();
				dto.setId(post.getId());
				dto.setTitle(post.getTitle());
				dto.setPostingDate(post.getPostingDate());
				return dto;
			})
			.collect(Collectors.toList());
	}

}
