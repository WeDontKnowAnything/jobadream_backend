package com.toyproject.jobadream.corp.dto;

import java.util.List;
import lombok.Data;

@Data
public class JobsDto {

	private String corpId;
	private String corpName;
	private String title;
	private String position;
	private List<JobUrlDto> jobUrls;
}