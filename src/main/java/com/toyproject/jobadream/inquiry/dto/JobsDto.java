package com.toyproject.jobadream.inquiry.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class JobsDto {
	private String id;
	private String corpName;
	private String title;
	private String position;
	private String location;
	private Integer experienceCode;
	private LocalDate openingDate;
	private LocalDate closingDate;
	private String corpId;
	private List<JobsUrlDto> url;
}

