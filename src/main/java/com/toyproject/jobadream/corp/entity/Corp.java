package com.toyproject.jobadream.corp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "Corporation")
@Entity
@Data
public class Corp {

	@Id
	private String id;
	private String name;
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "size_code")
	private String sizeCode;
	@Column(name = "employee_cnt")
	private int employeeCnt;
	@Column(name = "reg_gender")
	private int regGender;
	@Column(name = "tempo_gender")
	private int tempoGender;

}