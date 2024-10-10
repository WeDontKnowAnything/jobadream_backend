package com.toyproject.jobadream.inquiry.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "corporation")
@Data
public class CorporationEntity {
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "size_code")
	private String sizeCode;
	@Column(name = "employee_cnt")
	private Integer employeeCount;
	@Column(name = "reg_gender")
	private Integer regGender;
	@Column(name = "tempo_gender")
	private Integer tempoGender;
	@OneToMany(mappedBy = "corporation")
	private List<JobsEntity> jobs;
}
