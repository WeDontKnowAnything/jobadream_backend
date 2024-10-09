package com.toyproject.jobadream.bbs.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "post")
@Entity
@Data
public class PostEntity {
	@Id
	@Column(name = "id", columnDefinition = "serial4")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "postingDate")
	private LocalDateTime postingDate = LocalDateTime.now();

}
