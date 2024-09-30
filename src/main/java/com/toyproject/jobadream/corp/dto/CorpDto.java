package com.toyproject.jobadream.corp.dto;

import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
public class CorpDto {
	private String id;
	private String name;
	@OneToMany(mappedBy = "CorpDto")
	private List<JobDto> jobs;  // JobDto는 별도로 정의

}

