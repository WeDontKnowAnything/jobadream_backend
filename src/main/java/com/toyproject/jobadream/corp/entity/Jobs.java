package com.toyproject.jobadream.corp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "jobs")
@Data
public class Jobs {
	@Id
	private int id;
	@Column(name = "corp_name")
	private String corpName;
	private String title;
	private String position;
	private String location;
	@Column(name = "experience_code")
	private int experienceCode;
	@Column(name = "opening_date")
	private int openingDate;
	@Column(name = "closing_date")
	private int closingDate;
}
