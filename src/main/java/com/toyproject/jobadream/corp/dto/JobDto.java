package com.toyproject.jobadream.corp.dto;

import java.util.List;

import com.toyproject.jobadream.corp.entity.Corp;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

// JobDto 정의
@Data
public class JobDto {
	@ManyToOne
	@JoinColumn(name = "corp_id")  // 외래키로 설정
	private Corp corp;

	public String CorpName;
	public String title;
	public String position;
	@OneToMany(mappedBy = "JobDto")
	public List<JobUrlDto> jobUrl;  // JobUrlDto도 별도 정
}