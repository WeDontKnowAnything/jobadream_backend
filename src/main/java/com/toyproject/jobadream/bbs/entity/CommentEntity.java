package com.toyproject.jobadream.bbs.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "comm")
@Entity
@Data
public class CommentEntity {

	@Id
	@Column(name = "id", columnDefinition = "serial4")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "comment", columnDefinition = "TEXT")
	private String comment;
	@Column(name = "commentDate")
	private LocalDateTime commentDate = LocalDateTime.now();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
	private PostEntity post;

}
