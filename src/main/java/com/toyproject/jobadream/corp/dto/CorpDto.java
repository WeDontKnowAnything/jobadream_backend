package com.toyproject.jobadream.corp.dto;

import java.util.List;
import lombok.Data;

@Data
public class CorpDto {
	private String id;
	private String name;
	private List<JobsDto> jobs;
	//연관된 Job 데이터를 포함할 수 있습니다
}


