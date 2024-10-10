package com.toyproject.jobadream.inquiry.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "jobs")
@Data
public class JobsEntity {
	@Id
	private String id;
	@Column(name = "corp_name")
	private String corpName;
	@Column(name = "title")
	private String title;
	@Column(name = "position")
	private String position;
	@Column(name = "location")
	private String location;
	@Column(name = "experience_code")
	private Integer experienceCode;
	@Column(name = "opening_date")
	private LocalDate openingDate;
	@Column(name = "closing_date")
	private LocalDate closingDate;
	@ManyToOne
	@JoinColumn(name = "corp_id", nullable = false)
	private CorporationEntity corporation;
	@OneToMany(mappedBy = "job")
	private List<JobsUrlEntity> urls;
}