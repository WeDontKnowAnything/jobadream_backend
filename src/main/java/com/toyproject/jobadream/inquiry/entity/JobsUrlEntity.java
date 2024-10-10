package com.toyproject.jobadream.inquiry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "job_url")
@Data
public class JobsUrlEntity {
	@Id
	@Column(name = "id", columnDefinition = "serial4")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "platform_name")
	private String platformName;
	@Column(name = "url")
	private String url;
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private JobsEntity job;
}