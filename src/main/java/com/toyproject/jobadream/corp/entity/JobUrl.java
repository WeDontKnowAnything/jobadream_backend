package com.toyproject.jobadream.corp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "job_url")
@Data
public class JobUrl {
	@Id
	private int id;
	@Column(name = "platform_name")
	private String platformName;
	private String url;
	@Column(name = "job_id")
	private String jobId;
}