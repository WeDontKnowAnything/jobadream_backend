package com.toyproject.jobadream.bbs.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "post")
@Entity
@Data
public class PostEntity {
	@Id
	@Column(name = "id", columnDefinition = "serial4")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "posting_Date")
	private LocalDateTime postingDate = LocalDateTime.now();
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<CommentEntity> contents;
	@Column(name = "view_count")
	private Integer viewCount = 0;
}
