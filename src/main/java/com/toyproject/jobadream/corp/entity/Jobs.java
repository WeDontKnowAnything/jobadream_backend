package com.toyproject.jobadream.corp.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "jobs")
@Data
public class Jobs {
	@Id
	private String id;
	@Column(name = "corp_name")
	private String corpName;
	private String title;
	private String position;
	private String location;
	@Column(name = "experience_code")
	private int experienceCode;
	@Column(name = "opening_date")
	private Date openingDate;
	@Column(name = "closing_date")
	private Date closingDate;
	@Column(name = "corp_id")
	private String corpId;
}
