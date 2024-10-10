package com.toyproject.jobadream.inquiry.dto;

import lombok.Data;

@Data
public class CorporationDto {
	private String id;
	private String name;
	private String categoryCode;
	private String sizeCode;
	private Integer employeeCount;
	private Integer regGender;
	private Integer tempoGender;
}
